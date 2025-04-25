package com.lao.backend.todo_List.testBuilder;

import com.lao.backend.todo_List.domain.Priority;
import com.lao.backend.todo_List.domain.Status;
import com.lao.backend.todo_List.domain.Task;

import java.time.LocalDateTime;

public class TaskBuilder {
    private Long id = 1L;
    private String title = "Sample Task";
    private String description = "Sample Description";
    private Status status = Status.TODO;
    private Priority priority = Priority.MEDIUM;
    private String category = "Sample Category";
    private LocalDateTime creationDate = LocalDateTime.of(2025,12,3,10,55);

    private LocalDateTime startDate =LocalDateTime.of(2025,12,3,10,55);
    private LocalDateTime dueDate = startDate.plusDays(5);
    private LocalDateTime updatedDate = null;

    public TaskBuilder withId(Long id){
        this.id= id;
        return this;
    }

    public TaskBuilder withTitle(String title){
        this.title= title;
        return this;
    }

    public TaskBuilder withDescription(String description){
        this.description= description;
        return this;
    }
    public TaskBuilder withStatus(Status status){
        this.status= status;
        return this;
    }

    public TaskBuilder withPriority(Priority priority){
        this.priority= priority;
        return this;
    }

    public TaskBuilder withCategory(String category){
        this.category= category;
        return this;
    }
    public TaskBuilder withCreatedDate(LocalDateTime createdDate){
        this.creationDate = createdDate;
        return this;
    }
    public TaskBuilder withStartDateDate(LocalDateTime StartDate){
        this.startDate= startDate;
        return this;
    }
    public TaskBuilder withDueDate(LocalDateTime dueDate){
        this.dueDate= dueDate;
        return this;
    }
    public TaskBuilder withUpdatedDate(LocalDateTime updatedDate){
        this.updatedDate= updatedDate;
        return this;
    }
    public Task build(){
        return new Task(id,title,description,status,priority,category, creationDate,startDate,dueDate,updatedDate);
    }
}
