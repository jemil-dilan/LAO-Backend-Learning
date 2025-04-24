package com.lao.backend.todo_List.testBuilder;

import com.lao.backend.todo_List.dto.TaskDTO;

import java.time.LocalDateTime;

public class TaskDTOBuilder {
    private Long id = 1L;
    private String title = "Sample Task";
    private String description = "Sample Description";
    private String status = "TODO";
    private String priority = "MEDIUM";
    private String category = "Sample Category";
    private LocalDateTime createdDate = LocalDateTime.of(2025, 12, 3, 10, 55);
    private LocalDateTime dueDate = createdDate.plusDays(5);

    public TaskDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public TaskDTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public TaskDTOBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskDTOBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public TaskDTOBuilder withPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public TaskDTOBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public TaskDTOBuilder withCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public TaskDTOBuilder withDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public TaskDTO build() {
        return new TaskDTO(id, title, description, status, priority, category, createdDate, dueDate);
    }
}
