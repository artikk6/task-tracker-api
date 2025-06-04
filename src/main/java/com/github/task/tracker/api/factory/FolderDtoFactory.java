package com.github.task.tracker.api.factory;

import com.github.task.tracker.api.dto.FolderDto;
import com.github.task.tracker.store.entity.FolderEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectDtoFactory {
    public FolderDto makeProjectDto(FolderEntity entity) {
        return FolderDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
