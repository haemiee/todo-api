package com.haem.todo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haem.todo.domain.Task;
import com.haem.todo.dto.TaskCreateRequest;
import com.haem.todo.dto.TaskResponse;
import com.haem.todo.service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final TaskService taskService;
	
	@PostMapping
	public ResponseEntity<Long> createTask( @RequestBody TaskCreateRequest request ) {
		
		Long taskId = taskService.createTask(request);
		return ResponseEntity.ok(taskId);
		
	}
	
	@GetMapping
	public ResponseEntity<List<TaskResponse>> getTasks() {
		
		List<TaskResponse> tasks = taskService.getTasks();
		
		return ResponseEntity.ok(tasks);
	}
	
}
