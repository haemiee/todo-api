package com.haem.todo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaskCreateRequest {

	private String title;
	private String content;
	private LocalDate dueDate;
	
}
