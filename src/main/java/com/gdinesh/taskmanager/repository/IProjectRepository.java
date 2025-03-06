package com.gdinesh.taskmanager.repository;

import org.springframework.data.repository.CrudRepository;

import com.gdinesh.taskmanager.persistence.model.Project;


public interface IProjectRepository extends CrudRepository<Project, Long>{
}
