package com.lao.backend.todo_List.testBuilder;

import com.lao.backend.todo_List.domain.enums.Priority;
import com.lao.backend.todo_List.domain.enums.Status;
import com.lao.backend.todo_List.dto.TaskDTO;

import java.time.LocalDateTime;

public class TaskDTOBuilder {
    private Long id = 1L;
    private String title = "Sample Task";
    private String description = "Sample Description";
    private Status status = Status.TODO;
    private Priority priority = Priority.MEDIUM;
    private String category = "Sample Category";
    private LocalDateTime startDate = LocalDateTime.of(2025, 12, 3, 10, 55);
    private LocalDateTime dueDate = startDate.plusDays(5);

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

    public TaskDTOBuilder withStatus(Status status) {
        this.status = status;
        return this;
    }

    public TaskDTOBuilder withPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public TaskDTOBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public TaskDTOBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public TaskDTOBuilder withDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public TaskDTO build() {
        return new TaskDTO(id, title, description, status, priority, category, startDate, dueDate);
    }
}
