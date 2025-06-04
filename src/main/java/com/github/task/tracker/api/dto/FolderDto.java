package com.github.task.tracker.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.task.tracker.store.entity.TaskEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FolderDto {

    private Long id;

    private String name;

    @JsonProperty("created_at")
    private LocalDate createdAt;

    private List<TaskEntity> tasks;
}
