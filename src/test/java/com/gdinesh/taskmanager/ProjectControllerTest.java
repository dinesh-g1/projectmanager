package com.gdinesh.taskmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gdinesh.taskmanager.persistence.model.ProjectDto;
import com.gdinesh.taskmanager.web.controller.ProjectController;

@SpringBootTest
public class ProjectControllerTest {
    
    @Autowired
    private ProjectController projectController;
    
    @Test
    public void givenProject_whenCreate_thenSuccess() {
        ProjectDto projectDto = new ProjectDto(1L, "Project One", LocalDate.now());
        projectController.create(projectDto);

        ProjectDto projectDto2 = projectController.findOne(projectDto.getId());
        assertEquals(projectDto2.getId(), projectDto.getId());
    }
}
