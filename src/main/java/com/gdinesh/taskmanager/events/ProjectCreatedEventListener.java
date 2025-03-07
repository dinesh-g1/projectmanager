package com.gdinesh.taskmanager.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProjectCreatedEventListener {
    private final Logger LOG = LoggerFactory.getLogger(ProjectCreatedEvent.class);
    @EventListener
    public void projectCreated(ProjectCreatedEvent projectCreatedEvent) {
        LOG.info("Project with id {} is created", projectCreatedEvent.getProjectId());
    }
}
