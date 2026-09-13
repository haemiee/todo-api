package com.haem.todo.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void createTaskIncompleted() {
		// given
		Task task = new Task("Spring 공부", "JPA 복습하기", LocalDate.of(2026, 9, 13));

		// then
		assertThat(task.isCompleted()).isFalse();
	}
	
	@Test
	void toggleCompletedStatus() {
		
		// given
		Task task = new Task("Spring 공부", "JPA 복습하기", LocalDate.of(2026, 9, 13));
		
		// when
		task.toggleCompleted();
		
		// then
		assertThat(task.isCompleted()).isTrue();
	}
	
	@Test
	void updateTask() {
		
		// given
		Task task = new Task("Spring 공부", "JPA 복습하기", LocalDate.of(2026, 9, 13));
		
		// when
		task.update("Spring Boot 공부", "JPA 와 QueryDSL 복습하기", LocalDate.of(2026, 9, 20));
		
		// then
		assertThat(task.getTitle()).isEqualTo("Spring Boot 공부");
		assertThat(task.getContent()).isEqualTo("JPA 와 QueryDSL 복습하기");
		assertThat(task.getDueDate()).isEqualTo(LocalDate.of(2026, 9, 20));
	}
}
