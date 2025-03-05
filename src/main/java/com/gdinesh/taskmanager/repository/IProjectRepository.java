package com.gdinesh.taskmanager.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdinesh.taskmanager.persistence.model.Project;


@Repository
public interface IProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findByName(String name);
    List<Project> findByCreatedAtBetween(LocalDate start, LocalDate end);
}
