package com.github.task.tracker.api.controller;

import com.github.task.tracker.api.dto.FolderDto;
import com.github.task.tracker.api.dto.TaskDto;
import com.github.task.tracker.api.factory.ProjectDtoFactory;
import com.github.task.tracker.api.factory.ProjectWithTasksDto;
import com.github.task.tracker.api.factory.TaskDtoFactory;
import com.github.task.tracker.api.exception.BadRequestException;
import com.github.task.tracker.store.repository.FolderRepository;
import com.github.task.tracker.store.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api")
public class ProjectController {
    FolderRepository projectRepository;
    ProjectDtoFactory projectDtoFactory;
    TaskRepository taskRepository;
    TaskDtoFactory taskDtoFactory;

    @Autowired
    public ProjectController(
            FolderRepository projectRepository,
            ProjectDtoFactory projectDtoFactory,
            TaskRepository taskRepository,
            TaskDtoFactory taskDtoFactory)
    {
        this.projectRepository = projectRepository;
        this.projectDtoFactory = projectDtoFactory;
        this.taskRepository = taskRepository;
        this.taskDtoFactory = taskDtoFactory;
    }

    @GetMapping("/projects")
    public List<FolderDto> findAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectDtoFactory::makeProjectDto)
                .toList();
    }

    @GetMapping("/project/{id}")
    public ProjectWithTasksDto findProject(@PathVariable("id") Long id) {
        if (projectRepository.findById(id).isEmpty()) {
            throw new BadRequestException("no such project exists");
        } else {
            FolderDto project = projectRepository.findById(id)
                    .map(projectDtoFactory::makeProjectDto)
                    .get();
            List<TaskDto> tasks = taskRepository.findAll().stream()
                    .map(taskDtoFactory::makeProjectDto)
                    .toList();
            return new ProjectWithTasksDto(project, tasks);
        }
    }
}
