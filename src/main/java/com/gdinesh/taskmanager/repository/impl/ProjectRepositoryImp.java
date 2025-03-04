package com.gdinesh.taskmanager.repository.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.repository.IProjectRepository;

@Repository
public class ProjectRepositoryImp implements IProjectRepository{
    List<Project> projects = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    
    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        if (existingProject == null) {
            projects.add(project);
        } else {
            projects.remove(project);
            Project newProject = new Project(project.getId(), project.getName(), project.getCreatedAt());
            projects.add(newProject);
        }
        
        return project;
    }
    
}
