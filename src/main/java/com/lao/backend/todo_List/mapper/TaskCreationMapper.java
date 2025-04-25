package com.lao.backend.todo_List.mapper;

import com.lao.backend.todo_List.domain.Task;
import com.lao.backend.todo_List.dto.TaskCreationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskCreationMapper {

    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "id", ignore = true)
    Task toTask(TaskCreationDTO taskCreationDTO);

    TaskCreationDTO toCreationDTO (Task task);
}
