package com.gdinesh.taskmanager.repository;

import java.util.Optional;

import com.gdinesh.taskmanager.persistence.model.Project;

public interface IProjectRepository {
    Optional<Project> findById(Long id);
    Project save(Project project);
}
