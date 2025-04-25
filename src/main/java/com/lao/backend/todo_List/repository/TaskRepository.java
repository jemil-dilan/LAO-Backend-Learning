package com.lao.backend.todo_List.repository;

import com.lao.backend.todo_List.domain.Priority;
import com.lao.backend.todo_List.domain.Status;
import com.lao.backend.todo_List.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(Status status);

    List<Task> findAllByPriority(Priority priority);
}
