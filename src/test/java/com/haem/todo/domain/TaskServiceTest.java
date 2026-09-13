package com.haem.todo.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.haem.todo.dto.TaskResponse;
import com.haem.todo.exception.TaskNotFoundException;
import com.haem.todo.repository.TaskRepository;
import com.haem.todo.service.TaskService;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
	
	@Mock
	private TaskRepository taskRepository;
	
	@InjectMocks
	private TaskService taskService;
	
	@Test
	void getTaskById() {
		
		// given
		Long taskId = 1L;
		
		Task task = new Task("Spring 공부", "JPA 복습하기", LocalDate.of(2026, 9, 13));
		
		when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
		
		// when
		TaskResponse result = taskService.getTask(taskId);
		
		// then
		assertThat(result.getTitle()).isEqualTo("Spring 공부");
		assertThat(result.getContent()).isEqualTo("JPA 복습하기");
        assertThat(result.getDueDate())
                .isEqualTo(LocalDate.of(2026, 9, 13));
        assertThat(result.isCompleted()).isFalse();
	}
	
	@Test
	void throwExceptionWhenTaskNotFound() {
		
		// given
		Long taskId = 999L;
		
		when(taskRepository.findById(taskId)).thenReturn(Optional.empty());
		
		// when & then
		assertThatThrownBy(() -> taskService.getTask(taskId))
			.isInstanceOf(TaskNotFoundException.class)
			.hasMessage("Task not found: 999");
	}
	
	@Test
	void toggleTaskCompletedStatus() {
		
		// given
		Long taskId = 1L;
		
		Task task = new Task("Spring 공부", "JPA 복습하기", LocalDate.of(2026, 9, 13));
		
		when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
		
		// when
		taskService.toggleCompleted(taskId);
		
		// then
		assertThat(task.isCompleted()).isTrue();
		verify(taskRepository).findById(taskId);	// findById 메서드가 실제로 호출되었는지 확인
		
	}

	@Test
	void deleteTask() {
		
		// given
		Long taskId = 1L;
		Task task = new Task("Spring 공부", "JPA 복습하기", LocalDate.of(2026, 9, 13));

		when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));
		
		// when
		taskService.deleteTask(taskId);
		
		// then 
		verify(taskRepository).findById(taskId);
		verify(taskRepository).delete(task);
		
	}
}
