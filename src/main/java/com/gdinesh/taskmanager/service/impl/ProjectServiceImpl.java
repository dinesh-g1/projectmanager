package com.gdinesh.taskmanager.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.repository.IProjectRepository;
import com.gdinesh.taskmanager.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {
    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    IProjectRepository projectRepo;

    @Override
    public Optional<Project> findById(Long id) {
        LOG.debug("Found project by Id >> {} ", id);
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        LOG.debug("Saving Project >> {} ", project);
        return projectRepo.save(project);
    }
    
    @Autowired
    @Qualifier("projectRepositoryImp")
    public void setProjectRepo(IProjectRepository projectRepo) {
    	this.projectRepo = projectRepo;
    }

}
