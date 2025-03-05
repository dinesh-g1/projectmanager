package com.gdinesh.taskmanager;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gdinesh.taskmanager.persistence.model.Project;
import com.gdinesh.taskmanager.repository.IProjectRepository;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {
    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenNewProjectSaved_thenSuccess() {
        Project p = new Project(1L, "test project 1", LocalDate.now());
        projectRepository.save(p);

        assertThat(p, is(notNullValue()));
    }

    @Test
    public void givenId_retrieveProject_thenSuccess() {
        Project p = new Project(1L, "test project 1", LocalDate.now());
        projectRepository.save(p);

        Optional<Project> retrievedProject = projectRepository.findById(p.getId());
        assertEquals(p.getId(), retrievedProject.get().getId());
    }
}
