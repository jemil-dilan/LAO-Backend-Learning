package com.lao.backend.todo_List.dto;

import com.lao.backend.todo_List.domain.enums.Priority;

import java.time.LocalDateTime;

public class TaskCreationDTO {
    private String title;
    private String description;
    private Priority priority;
    private String category;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;

    public TaskCreationDTO() {
    }

    public TaskCreationDTO(String title, String description, Priority priority, String category, LocalDateTime startDate, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
