package com.demo.lovable_clone.service;

import com.demo.lovable_clone.dto.member.InviteMemberRequest;
import com.demo.lovable_clone.dto.member.MemberResponse;
import com.demo.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.demo.lovable_clone.entity.ProjectMember;

import java.util.List;

public interface ProjectMemberService {

    List<MemberResponse> getProjectMembers(Long projectId, Long userId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest memberRoleRequest, Long userId);

    MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
