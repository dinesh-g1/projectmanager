
package com.gdinesh.taskmanager.service;

import java.util.Optional;

import com.gdinesh.taskmanager.persistence.model.Project;

public interface IProjectService {
    Optional<Project> findById(Long id);
    Project save(Project project);
}
