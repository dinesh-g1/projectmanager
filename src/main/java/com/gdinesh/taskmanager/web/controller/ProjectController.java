package com.gdinesh.taskmanager.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gdinesh.taskmanager.events.ProjectCreatedEvent;
import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.persistence.model.ProjectDto;
import com.gdinesh.taskmanager.service.IProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    private final IProjectService projectService;
    @Autowired
    private ApplicationEventPublisher publisher;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value="/{id}")
    public ProjectDto findOne(@PathVariable Long id) {
        Project p = projectService.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project Not Found"));
        return convertToProjectDto(p);
    }
    @PostMapping
    public void create(@RequestBody ProjectDto projectDto) {
        projectService.save(convertToProject(projectDto));
        publisher.publishEvent(new ProjectCreatedEvent(projectDto.getId()));
    }

    private Project convertToProject(ProjectDto projectDto) {
        return new Project(projectDto.getId(), projectDto.getName(), projectDto.getCreatedAt());
    }

    private ProjectDto convertToProjectDto(Project project) {
        return new ProjectDto(project.getId(), project.getName(), project.getCreatedAt());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleInternalServerError(Exception ex) {
        return new ResponseEntity<>("In the local controller", HttpStatus.NOT_FOUND);
    }
}
