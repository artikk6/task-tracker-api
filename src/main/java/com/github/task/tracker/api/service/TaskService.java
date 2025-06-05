package com.github.task.tracker.api.service;

import com.github.task.tracker.api.dto.TaskDto;
import com.github.task.tracker.api.exception.BadRequestException;
import com.github.task.tracker.api.factory.TaskDtoFactory;
import com.github.task.tracker.store.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private TaskDtoFactory taskDtoFactory;

    public TaskService(TaskRepository taskRepository, TaskDtoFactory taskDtoFactory) {
        this.taskRepository = taskRepository;
        this.taskDtoFactory = taskDtoFactory;
    }

    public TaskDto findTask(Long folderID, Long id) {

        if (taskRepository.findByIdAndFolderId(id, folderID).isEmpty()) {
            throw new BadRequestException("Task not found");
        }

        return taskDtoFactory.makeProjectDto(taskRepository.findByIdAndFolderId(id, folderID).get());
    }
}
