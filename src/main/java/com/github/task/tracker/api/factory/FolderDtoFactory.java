package com.github.task.tracker.api.factory;

import com.github.task.tracker.api.dto.FolderDto;
import com.github.task.tracker.store.entity.FolderEntity;
import org.springframework.stereotype.Component;

@Component
public class FolderDtoFactory {

    public FolderDto makeFolderDto(FolderEntity entity) {

        return FolderDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .tasks(entity.getTasks())
                .build();
    }
}
