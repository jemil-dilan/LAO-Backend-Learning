package com.lao.backend.todo_List.testBuilder;

import com.lao.backend.todo_List.domain.Priority;
import com.lao.backend.todo_List.domain.Status;
import com.lao.backend.todo_List.dto.TaskCreationDTO;

import java.time.LocalDateTime;

public class TaskCreationBuilder {
    private String title = "Sample Task";
    private String description = "Sample Description";
    private Priority priority = Priority.MEDIUM;
    private String category = "Sample Category";
    private LocalDateTime startDate = LocalDateTime.of(2025, 12, 3, 10, 55);
    private LocalDateTime dueDate = startDate.plusDays(5);

    public TaskCreationBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskCreationBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskCreationBuilder withPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public TaskCreationBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public TaskCreationBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public TaskCreationBuilder withDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public TaskCreationDTO build(){
        return new TaskCreationDTO(title, description, priority, category, startDate, dueDate);
    }
}
