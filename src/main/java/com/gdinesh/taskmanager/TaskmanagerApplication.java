package com.gdinesh.taskmanager;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.service.IProjectService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TaskmanagerApplication {

	@Autowired
	private IProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

	@PostConstruct
	public void postConstruct() {
		projectService.save(new Project(1L, "naya project", LocalDate.now()));
	}
}
