package com.haem.todo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haem.todo.dto.TaskCreateRequest;
import com.haem.todo.dto.TaskResponse;
import com.haem.todo.dto.TaskUpdateRequest;
import com.haem.todo.service.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

	private final TaskService taskService;

	@PostMapping
	public ResponseEntity<Long> createTask(@Valid @RequestBody TaskCreateRequest request) {

		Long taskId = taskService.createTask(request);
		return ResponseEntity.ok(taskId);

	}

	@GetMapping
	public ResponseEntity<Page<TaskResponse>> getTasks(
				@RequestParam(required = false, name = "keyword") String keyword,
					Pageable pageable ) {

		if( keyword == null || keyword.isBlank() ) {
			return ResponseEntity.ok(taskService.getTasks(pageable));
		}
		
		return ResponseEntity.ok(taskService.searchTasks(keyword, pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TaskResponse> getTask(@PathVariable("id") Long id) {
		TaskResponse task = taskService.getTask(id);
		return ResponseEntity.ok(task);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateTask(@PathVariable("id") Long id, @RequestBody TaskUpdateRequest request) {

		taskService.updateTask(id, request);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
		taskService.deleteTask(id);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/{id}/complete")
	public ResponseEntity<Void> toggleCompleted(@PathVariable("id") Long id) {
		taskService.toggleCompleted(id);

		return ResponseEntity.ok().build();
	}
}
