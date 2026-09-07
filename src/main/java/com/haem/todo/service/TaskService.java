package com.haem.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.haem.todo.domain.Task;
import com.haem.todo.dto.TaskCreateRequest;
import com.haem.todo.dto.TaskResponse;
import com.haem.todo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

	private final TaskRepository taskRepository;
	
	// create
	public Long createTask(TaskCreateRequest request) {
		
		Task task = new Task(
				request.getTitle(),
				request.getContent(),
				request.getDueDate()
		);
		
		Task savedTask = taskRepository.save(task);
		
		return savedTask.getId();
	}
	
	// get list
	public List<TaskResponse> getTasks() {
		return taskRepository.findAll()
				.stream()
				.map(TaskResponse::new)
				.toList();
	}
}
