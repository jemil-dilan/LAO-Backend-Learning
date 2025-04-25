package com.lao.backend.todo_List.service;

import com.lao.backend.todo_List.domain.enums.Priority;
import com.lao.backend.todo_List.domain.enums.Status;
import com.lao.backend.todo_List.domain.Task;
import com.lao.backend.todo_List.dto.TaskCreationDTO;
import com.lao.backend.todo_List.dto.TaskDTO;
import com.lao.backend.todo_List.mapper.TaskCreationMapper;
import com.lao.backend.todo_List.mapper.TaskMapper;
import com.lao.backend.todo_List.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private TaskCreationMapper taskCreationMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper, TaskCreationMapper taskCreationMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.taskCreationMapper = taskCreationMapper;
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

    public TaskDTO createTask(TaskCreationDTO taskCreationDTO) {
        if(!taskRepository.existsByTitle((taskCreationDTO.getTitle()))){
            if (taskCreationDTO.getPriority() == null){ taskCreationDTO.setPriority(Priority.MEDIUM);};
            Task task = taskCreationMapper.toTask(taskCreationDTO);
            task.setCreationDate(LocalDateTime.now());
            task.setStatus(updateTaskStatus(task.getStartDate(), task.getDueDate()));
            return taskMapper.toTaskDTO(taskRepository.save(task));
        }

        throw new RuntimeException("task already exist");
    }

    public void updateTask(Long taskId, TaskCreationDTO taskCreationDTO){
        if (taskRepository.existsById(taskId)){
            Task task = taskCreationMapper.toTask(taskCreationDTO);
            task.setUpdatedDate(LocalDateTime.now());
            taskRepository.save(task);
        }
    }

    public List<TaskDTO> getTaskByStatus(Status status) {
        return taskRepository.findAllByStatus(status).stream().map(taskMapper::toTaskDTO).toList();
    }

    public List<TaskDTO> getTaskByPriority(Priority priority) {
        return taskRepository.findAllByPriority(priority).stream().map(taskMapper::toTaskDTO).toList();
    }

    public Status updateTaskStatus(LocalDateTime startDate, LocalDateTime dueDate) {
        LocalDateTime now = LocalDateTime.now();

        if (startDate != null && dueDate != null){
            if (now.isBefore(startDate)){
                return Status.TODO;
            } else if (now.isAfter(startDate) && now.isBefore(dueDate)) {
                return Status.IN_PROGRESS;
            } else if (now.isAfter(startDate) && now.isAfter(dueDate)) {
                return Status.DONE;
            }
        }
        return Status.TODO;
    }
}
