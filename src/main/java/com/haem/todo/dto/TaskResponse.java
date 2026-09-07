package com.haem.todo.dto;

import java.time.LocalDate;

import com.haem.todo.domain.Task;

import lombok.Getter;

@Getter
public class TaskResponse {

	private Long id;
	private String title;
	private String content;
	private LocalDate dueDate;
	private boolean completed;

	public TaskResponse(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.content = task.getContent();
		this.dueDate = task.getDueDate();
		this.completed = task.isCompleted();
	}
}
