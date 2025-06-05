package com.github.task.tracker.api.controller;

import com.github.task.tracker.api.service.TasksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/folder/{id}")
public class TasksController {
    private final TasksService tasksService;

    private static final String FIND_TASKS = "";

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
}
