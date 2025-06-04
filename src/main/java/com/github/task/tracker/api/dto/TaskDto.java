package com.github.task.tracker.api.dto;

import com.github.task.tracker.store.entities.ProjectEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TaskDto {
    Long id;
    String name;
    String description;
    LocalDate createdAt;
    ProjectEntity project;
}
