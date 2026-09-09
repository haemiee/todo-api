package com.haem.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haem.todo.domain.Task;
import com.haem.todo.dto.TaskCreateRequest;
import com.haem.todo.dto.TaskResponse;
import com.haem.todo.dto.TaskUpdateRequest;
import com.haem.todo.exception.TaskNotFoundException;
import com.haem.todo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
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
	
	// 상세 조회
	public TaskResponse getTask(Long id) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));
		return new TaskResponse(task);
	}
	
	// update
	@Transactional
	public void updateTask(Long id, TaskUpdateRequest request) {
		
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));
		
		task.update(
				request.getTitle(),
				request.getContent(),
				request.getDueDate()				
				);
	}
	
	@Transactional
	public void deleteTask( Long id ) {
		Task task = taskRepository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));
		
		taskRepository.delete(task);
	}
}
