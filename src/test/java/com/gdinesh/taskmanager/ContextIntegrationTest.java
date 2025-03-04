package com.gdinesh.taskmanager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.service.IProjectService;

@SpringJUnitConfig(classes=TestConfig.class)
public class ContextIntegrationTest {
    @Autowired
    private IProjectService projectService;

    @Test
    public void whenProjectSave_thenOK() {
        Project savedProject = projectService.save(new Project(1L, "project name", LocalDate.now()));

        assertEquals(savedProject, is(notNullValue()));
    }
}
