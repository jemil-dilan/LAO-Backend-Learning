package com.lao.backend.todo_List.service;

import com.lao.backend.todo_List.domain.Task;
import com.lao.backend.todo_List.dto.TaskDTO;
import com.lao.backend.todo_List.mapper.TaskMapper;
import com.lao.backend.todo_List.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    TaskRepository taskRepository;
    TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::toTaskDTO).toList();
    }

    public TaskDTO getTaskById(Long taskId) {
        return taskRepository.findById(taskId).map(taskMapper::toTaskDTO).orElseThrow();
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        if(!taskRepository.existsById(taskDTO.getId())){
            Task task = taskRepository.save(taskMapper.toTask(taskDTO));
            return taskMapper.toTaskDTO(task);
        } else {
            throw new RuntimeException("task already exist");
        }
    }

}
