package com.haem.todo.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task")
@Getter @Setter
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String content; 
	
	private LocalDate dueDate;
	
	private boolean completed;
	
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	// Entity의 상태 변경을 Entity 내부에서 관리
	
	public Task(String title, String content, LocalDate dueDate) {
		this.title = title;
		this.content = content;
		this.dueDate = dueDate;
		this.completed = false;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	public void update(String title, String content, LocalDate dueDate) {
		this.title = title;
	    this.content = content;
	    this.dueDate = dueDate;
	    this.updatedAt = LocalDateTime.now();
	}
	
	public void toggleCompelted() {
		this.completed = !this.completed;
		this.updatedAt = LocalDateTime.now();
	}
	
}
