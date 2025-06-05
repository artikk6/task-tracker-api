package com.github.task.tracker.api.controller;

import com.github.task.tracker.api.dto.TaskDto;
import com.github.task.tracker.api.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/folder/{folderID}")
public class TaskController {
    private final TaskService taskService;

    private static final String FIND_TASK = "/task/{id}";

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(FIND_TASK)
    public TaskDto findTask(@PathVariable("folderID") Long folderID, @PathVariable("id") Long id) {
        return taskService.findTask(folderID, id);
    }

}
