package com.github.task.tracker.api.dto.factories;

import com.github.task.tracker.api.dto.ProjectDto;
import com.github.task.tracker.api.dto.TaskDto;

import java.util.List;

public class ProjectWithTasksDto {
    public ProjectDto project;
    public List<TaskDto> tasks;

    public ProjectWithTasksDto(ProjectDto project, List<TaskDto> tasks) {
        this.project = project;
        this.tasks = tasks;
    }
}
