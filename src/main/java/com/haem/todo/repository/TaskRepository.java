package com.haem.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haem.todo.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
