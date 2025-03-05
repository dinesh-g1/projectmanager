package com.gdinesh.taskmanager;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
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
    public void givenId_whenFindById_thenSuccess() {
        Project p = new Project(1L, "test project 1", LocalDate.now());
        projectRepository.save(p);

        Optional<Project> retrievedProject = projectRepository.findById(p.getId());
        assertEquals(p.getId(), retrievedProject.get().getId());
    }

    @Test
    public void givenProjectName_whenFindByName_thenSuccess() {
        Project p = new Project(1L, "test project 1", LocalDate.now());
        projectRepository.save(p);

        Optional<Project> retrievedProject = projectRepository.findByName(p.getName());
        assertEquals(p, retrievedProject.get());
    }

    @Test
    public void givenProjectCreatedAt_whenFindByCreatedAtBetween_thenSuccess() {
        Project p = new Project(1L, "test project 1", LocalDate.now());
        projectRepository.save(p);

        Project p1 = new Project(2L, "test project 2", LocalDate.now());
        projectRepository.save(p1);

        Project p3 = new Project(3L, "old project 3", LocalDate.now().minusYears(1));
        projectRepository.save(p3);

        List<Project> retrievedProjects = projectRepository.findByCreatedAtBetween(LocalDate.now().minusDays(1L), LocalDate.now().plusDays(1L));
        
        assertThat(retrievedProjects, hasItems(p, p1));
    }
}
