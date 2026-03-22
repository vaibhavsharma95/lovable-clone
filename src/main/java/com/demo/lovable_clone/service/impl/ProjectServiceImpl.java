package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.project.ProjectRequest;
import com.demo.lovable_clone.dto.project.ProjectResponse;
import com.demo.lovable_clone.dto.project.ProjectSummaryResponse;
import com.demo.lovable_clone.entity.Project;
import com.demo.lovable_clone.entity.User;
import com.demo.lovable_clone.mapper.ProjectMapper;
import com.demo.lovable_clone.repository.ProjectRepository;
import com.demo.lovable_clone.repository.UserRepository;
import com.demo.lovable_clone.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .build();

        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        // return projectRepository.findAllAccessibleByUser(userId).stream().map(projectMapper::toProjectSumma ryResponse).collect(Collectors.toList());
        return projectMapper.toProjectSummaryResponseList(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponse getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        project.setName(request.name());
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Only owner can update name.");
        }
        project = projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleProjectById(id, userId);
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Only owner can delete the project");
        }
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    private Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleProjectById(id, userId).orElseThrow();
    }
}
