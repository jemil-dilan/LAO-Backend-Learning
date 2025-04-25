package com.lao.backend.todo_List.mapper;

import com.lao.backend.todo_List.domain.Task;
import com.lao.backend.todo_List.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toTaskDTO(Task task);

    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    Task toTask(TaskDTO taskDTO);
}
