package com.lao.backend.todo_List.controller;

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

    @DeleteMapping("/{tasKId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long tasKId){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
