package com.lao.backend.todo_List.controller;

import com.lao.backend.todo_List.domain.enums.Priority;
import com.lao.backend.todo_List.domain.enums.Status;
import com.lao.backend.todo_List.dto.TaskCreationDTO;
import com.lao.backend.todo_List.dto.TaskDTO;
import com.lao.backend.todo_List.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long taskId){
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskCreationDTO taskCreationDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskCreationDTO));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Void> updateTask(@RequestBody TaskCreationDTO taskCreationDTO, @PathVariable Long taskId){
        taskService.updateTask(taskId, taskCreationDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/status/{taskStatus}")
    public ResponseEntity<List<TaskDTO>> getTaskByStatus(@PathVariable String taskStatus){
        Status status = Status.valueOf(taskStatus.toUpperCase());
        return ResponseEntity.ok(taskService.getTaskByStatus(status));
    }

    @GetMapping("/priority/{taskPriority}")
    public ResponseEntity<List<TaskDTO>> getTaskByPriority(@PathVariable String taskPriority){
        Priority priority = Priority.valueOf(taskPriority.toUpperCase());
        return ResponseEntity.ok(taskService.getTaskByPriority(priority));
    }

}
