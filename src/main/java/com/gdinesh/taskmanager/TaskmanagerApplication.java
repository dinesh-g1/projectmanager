package com.gdinesh.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskmanagerApplication {

	// @Autowired
	// private IProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

	// @PostConstruct
	// public void postConstruct() {
	// 	projectService.save(new Project(1L, "naya project", LocalDate.now()));
	// }
}
