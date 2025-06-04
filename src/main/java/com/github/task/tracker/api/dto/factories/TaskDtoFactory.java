package com.github.task.tracker.api.dto.factories;

import com.github.task.tracker.api.dto.ProjectDto;
import com.github.task.tracker.api.dto.TaskDto;
import com.github.task.tracker.store.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoFactory {
    public TaskDto makeProjectDto(TaskEntity entity) {
        return TaskDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .description(entity.getDescription())
                .build();
    }
}
