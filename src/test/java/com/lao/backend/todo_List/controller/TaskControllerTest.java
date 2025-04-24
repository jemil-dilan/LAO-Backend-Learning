package com.lao.backend.todo_List.controller;

import com.lao.backend.todo_List.dto.TaskDTO;
import com.lao.backend.todo_List.service.TaskService;
import com.lao.backend.todo_List.testBuilder.TaskBuilder;
import com.lao.backend.todo_List.testBuilder.TaskDTOBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    TaskService taskService;

    TaskDTOBuilder taskDTOBuilder = new TaskDTOBuilder();
    TaskBuilder taskBuilder = new TaskBuilder();

    @Test
    public void testGetAllTasks() throws Exception {
        List<TaskDTO> taskDTOList = List.of(taskDTOBuilder.build(), taskDTOBuilder.
                withTitle("ddcq").withCategory("scqsc").withDescription("qscsqcscs")
                .withId(2L).withStatus("IN_PROGRESS").build());

        when(taskService.getAllTasks()).thenReturn(taskDTOList);

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(taskDTOList.getFirst().getId()))
                .andExpect(jsonPath("$[0].title").value(taskDTOList.getFirst().getTitle()))
                .andExpect(jsonPath("$[0].description").value(taskDTOList.getFirst().getDescription()))
                .andExpect(jsonPath("$[0].status").value(taskDTOList.getFirst().getStatus()))
                .andExpect(jsonPath("$[0].priority").value(taskDTOList.getFirst().getPriority()))
                .andExpect(jsonPath("$[0].category").value(taskDTOList.getFirst().getCategory()))
                .andExpect(jsonPath("$[0].createdDate", Matchers.startsWith(taskDTOList.getFirst().getCreatedDate().toString())))
                .andExpect(jsonPath("$[0].dueDate", Matchers.startsWith(taskDTOList.getFirst().getDueDate().toString())));
    }

    @Test
    public void GetTaskByIdTest() throws Exception {
        var taskDTO = taskDTOBuilder.build();

        when(taskService.getTaskById(anyLong())).thenReturn(taskDTO);

        mockMvc.perform(get("/tasks/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(taskDTO.getId()))
                .andExpect(jsonPath("$.title").value(taskDTO.getTitle()))
                .andExpect(jsonPath("$.description").value(taskDTO.getDescription()))
                .andExpect(jsonPath("$.status").value(taskDTO.getStatus()))
                .andExpect(jsonPath("$.priority").value(taskDTO.getPriority()))
                .andExpect(jsonPath("$.category").value(taskDTO.getCategory()))
                .andExpect(jsonPath("$.createdDate", Matchers.startsWith(taskDTO.getCreatedDate().toString())))
                .andExpect(jsonPath("$.dueDate", Matchers.startsWith(taskDTO.getDueDate().toString())));
    }

    @Test
    public void deleteTaskBTest() throws Exception {

        doNothing().when(taskService).deleteTask(anyLong());

        mockMvc.perform(delete("/tasks/4"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void createTaskBTest() throws Exception {

        doNothing().when(taskService).deleteTask(anyLong());

        mockMvc.perform(delete("/tasks/4"))
                .andExpect(status().isNoContent());
    }


}