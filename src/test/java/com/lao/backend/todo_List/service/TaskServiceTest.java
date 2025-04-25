package com.lao.backend.todo_List.service;

import com.lao.backend.todo_List.domain.Priority;
import com.lao.backend.todo_List.domain.Status;
import com.lao.backend.todo_List.domain.Task;
import com.lao.backend.todo_List.dto.TaskCreationDTO;
import com.lao.backend.todo_List.dto.TaskDTO;
import com.lao.backend.todo_List.mapper.TaskCreationMapper;
import com.lao.backend.todo_List.mapper.TaskMapper;
import com.lao.backend.todo_List.repository.TaskRepository;
import com.lao.backend.todo_List.testBuilder.TaskBuilder;
import com.lao.backend.todo_List.testBuilder.TaskCreationBuilder;
import com.lao.backend.todo_List.testBuilder.TaskDTOBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;

    @Mock
    TaskCreationMapper taskCreationMapper;
    @InjectMocks
    TaskService taskService;

    TaskBuilder taskBuilder = new TaskBuilder();
    TaskDTOBuilder taskDTOBuilder = new TaskDTOBuilder();

    TaskCreationBuilder taskCreationBuilder = new TaskCreationBuilder();

    @Test
    public void testGetAllTasks() {
        // Given
        var task = taskBuilder.build();
        var taskDTO = taskDTOBuilder.build();


        // When
        when(taskRepository.findAll()).thenReturn(List.of(task));
        when(taskMapper.toTaskDTO(any(Task.class))).thenReturn(taskDTO);
        var result = taskService.getAllTasks();
        // Then

        assertThat(result).hasSize(1).contains(taskDTO);
        assertEquals(taskDTO.getId(), result.getFirst().getId());
        assertEquals(taskDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(taskDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(taskDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(taskDTO.getPriority(), result.getFirst().getPriority());
        assertEquals(taskDTO.getCategory(), result.getFirst().getCategory());
        assertEquals(taskDTO.getStartDate(), result.getFirst().getStartDate());
        assertEquals(taskDTO.getDueDate(), result.getFirst().getDueDate());

        verify(taskRepository).findAll();
        verify(taskMapper).toTaskDTO(any(Task.class));
    }

    @Test
    public void testGetTaskById(){
        //Given
        var task = taskBuilder.build();
        var taskDTO = taskDTOBuilder.build();

        //When
        when(taskRepository.findById(anyLong())).thenReturn(Optional.of(task));
        when(taskMapper.toTaskDTO(any(Task.class))).thenReturn(taskDTO);
        //Then
        var result = taskService.getTaskById(1L);

        assertEquals(taskDTO.getId(), result.getId());
        assertEquals(taskDTO.getTitle(), result.getTitle());
        assertEquals(taskDTO.getDescription(), result.getDescription());
        assertEquals(taskDTO.getStatus(), result.getStatus());
        assertEquals(taskDTO.getPriority(), result.getPriority());
        assertEquals(taskDTO.getCategory(), result.getCategory());
        assertEquals(taskDTO.getStartDate(), result.getStartDate());
        assertEquals(taskDTO.getDueDate(), result.getDueDate());
        assertThat(taskDTO).isEqualTo(result);

        verify(taskRepository).findById(anyLong());
        verify(taskMapper).toTaskDTO(any(Task.class));
    }

    @Test
    public void deleteTaskTest(){
        doNothing().when(taskRepository).deleteById(anyLong());
        taskService.deleteTask(1L);

        verify(taskRepository).deleteById(anyLong());
    }

    @Test
    public void creatTaskTest(){
        //Given
        var task = taskBuilder.build();
        var taskDTO = taskDTOBuilder.build();
        var taskCreation = taskCreationBuilder.build();

        //When
        when(taskRepository.existsByTitle(anyString())).thenReturn(false);
        when(taskCreationMapper.toTask(any(TaskCreationDTO.class))).thenReturn(task);
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        when(taskMapper.toTaskDTO(any(Task.class))).thenReturn(taskDTO);
        //Then
        var result = taskService.createTask(taskCreation);

        assertEquals(taskDTO.getId(), result.getId());
        assertEquals(taskDTO.getTitle(), result.getTitle());
        assertEquals(taskDTO.getDescription(), result.getDescription());
        assertEquals(taskDTO.getStatus(), result.getStatus());
        assertEquals(taskDTO.getPriority(), result.getPriority());
        assertEquals(taskDTO.getCategory(), result.getCategory());
        assertEquals(taskDTO.getStartDate(), result.getStartDate());
        assertEquals(taskDTO.getDueDate(), result.getDueDate());
        assertThat(taskDTO).isEqualTo(result);

        verify(taskRepository).existsByTitle(anyString());
        verify(taskCreationMapper).toTask(any(TaskCreationDTO.class));
        verify(taskRepository).save(any(Task.class));
        verify(taskMapper).toTaskDTO(any(Task.class));

    }

    @Test
    public void updateTaskTest(){
        //Given
        var updatedTaskCreation = taskCreationBuilder.withTitle("boom").build();
        var updatedTask = taskBuilder.withTitle("boom").build();
        var updatedTaskDTO = taskDTOBuilder.withTitle("boom").build();

        //When
        when(taskRepository.existsById(anyLong())).thenReturn(true);
        when(taskCreationMapper.toTask(any(TaskCreationDTO.class))).thenReturn(updatedTask);
        when(taskRepository.save(any(Task.class))).thenReturn(updatedTask);
        when(taskRepository.findAll()).thenReturn(List.of(updatedTask));
        when(taskMapper.toTaskDTO(any(Task.class))).thenReturn(updatedTaskDTO);
        //Then
        taskService.updateTask(1L, updatedTaskCreation);
        var result = taskService.getAllTasks();

        assertThat(result).hasSize(1).contains(updatedTaskDTO);
        assertEquals(updatedTaskDTO.getId(), result.getFirst().getId());
        assertEquals(updatedTaskDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(updatedTaskDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(updatedTaskDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(updatedTaskDTO.getPriority(), result.getFirst().getPriority());
        assertEquals(updatedTaskDTO.getCategory(), result.getFirst().getCategory());
        assertEquals(updatedTaskDTO.getStartDate(), result.getFirst().getStartDate());
        assertEquals(updatedTaskDTO.getDueDate(), result.getFirst().getDueDate());

        verify(taskRepository).existsById(anyLong());
        verify(taskCreationMapper).toTask(any(TaskCreationDTO.class));
        verify(taskRepository).save(any(Task.class));
        verify(taskMapper).toTaskDTO(any(Task.class));
        verify(taskRepository).findAll();
        verify(taskMapper).toTaskDTO(any(Task.class));
    }

    @Test
    public void testGetTaskByStatus(){
        //Given
        var task = taskBuilder.build();
        var taskDTO = taskDTOBuilder.build();

        //When
        when(taskRepository.findAllByStatus(any(Status.class))).thenReturn(List.of(task));
        when(taskMapper.toTaskDTO(any(Task.class))).thenReturn(taskDTO);
        //Then
        var result = taskService.getTaskByStatus(Status.DONE);

        assertThat(result).hasSize(1).contains(taskDTO);
        assertEquals(taskDTO.getId(), result.getFirst().getId());
        assertEquals(taskDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(taskDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(taskDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(taskDTO.getPriority(), result.getFirst().getPriority());
        assertEquals(taskDTO.getCategory(), result.getFirst().getCategory());
        assertEquals(taskDTO.getStartDate(), result.getFirst().getStartDate());
        assertEquals(taskDTO.getDueDate(), result.getFirst().getDueDate());

        verify(taskRepository).findAllByStatus(any(Status.class));
        verify(taskMapper).toTaskDTO(any(Task.class));

    }

    @Test
    public void testGetTaskByPriority(){
        //Given
        var task = taskBuilder.build();
        var taskDTO = taskDTOBuilder.build();

        //When
        when(taskRepository.findAllByPriority((any(Priority.class)))).thenReturn(List.of(task));
        when(taskMapper.toTaskDTO(any(Task.class))).thenReturn(taskDTO);
        //Then
        var result = taskService.getTaskByPriority(Priority.LOW);

        assertThat(result).hasSize(1).contains(taskDTO);
        assertEquals(taskDTO.getId(), result.getFirst().getId());
        assertEquals(taskDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(taskDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(taskDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(taskDTO.getPriority(), result.getFirst().getPriority());
        assertEquals(taskDTO.getCategory(), result.getFirst().getCategory());
        assertEquals(taskDTO.getStartDate(), result.getFirst().getStartDate());
        assertEquals(taskDTO.getDueDate(), result.getFirst().getDueDate());

        verify(taskRepository).findAllByPriority((any(Priority.class)));
        verify(taskMapper).toTaskDTO(any(Task.class));

    }
}


