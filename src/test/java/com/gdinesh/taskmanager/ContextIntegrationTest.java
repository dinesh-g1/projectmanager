package com.gdinesh.taskmanager;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes=TestConfig.class)
public class ContextIntegrationTest {
    // @Autowired
    // private IProjectService projectService;

    // @Test
    // public void whenProjectSave_thenOK() {
    //     Project savedProject = projectService.save(new Project(1L, "project name", LocalDate.now()));

    //     assertEquals(savedProject, is(notNullValue()));
    // }
}
