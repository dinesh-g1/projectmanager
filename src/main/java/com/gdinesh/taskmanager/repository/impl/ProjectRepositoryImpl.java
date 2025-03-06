package com.gdinesh.taskmanager.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.repository.IProjectRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Optional<Project> findById(Long id) {
        Project p = entityManager.find(Project.class, id);
        return Optional.ofNullable(p);
    }

    @Override
    public Project save(Project project) {
        return entityManager.merge(project);
    }
    
}
