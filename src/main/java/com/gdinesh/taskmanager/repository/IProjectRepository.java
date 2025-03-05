package com.gdinesh.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdinesh.taskmanager.persistence.model.Project;

@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {}
