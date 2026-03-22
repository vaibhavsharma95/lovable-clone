package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.member.InviteMemberRequest;
import com.demo.lovable_clone.dto.member.MemberResponse;
import com.demo.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.demo.lovable_clone.entity.Project;
import com.demo.lovable_clone.entity.ProjectMember;
import com.demo.lovable_clone.entity.ProjectMemberId;
import com.demo.lovable_clone.entity.User;
import com.demo.lovable_clone.mapper.ProjectMemberMapper;
import com.demo.lovable_clone.repository.ProjectMemberRepository;
import com.demo.lovable_clone.repository.ProjectRepository;
import com.demo.lovable_clone.repository.UserRepository;
import com.demo.lovable_clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    ProjectRepository projectRepository;
    ProjectMemberRepository projectMemberRepository;
    ProjectMemberMapper projectMemberMapper;
    UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        List<MemberResponse> members = new ArrayList<>();
        members.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        members.addAll(projectMemberRepository.findByIdProjectId(projectId)
                .stream()
                .map(projectMemberMapper::toProjectMemberResponseFromMember)
                .toList());

        return members;
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }
        User invitee = userRepository.findByEmail(request.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("User is already a member of the project");
        }

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(projectMember);
        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest memberRoleRequest, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);

        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow(() -> new RuntimeException("Project member not found"));
        projectMember.setProjectRole(memberRoleRequest.role());
        projectMemberRepository.save(projectMember);


        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);
        if(!project.getOwner().getId().equals(userId)){
            throw new RuntimeException("Not Allowed");
        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("User is already a member of the project");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    private Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id, userId).orElseThrow();
    }
}
