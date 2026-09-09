package com.haem.todo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaskCreateRequest {

	
	@NotBlank(message = "제목을 입력해주세요.")
	private String title;
	
	private String content;
	
	@NotNull(message = "마감일을 입력해주세요.")
	private LocalDate dueDate;
	
}
