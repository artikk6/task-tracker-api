package com.github.task.tracker.store.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "folder")
public class FolderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @OneToMany
    @JoinColumn(name="folder_id")
    private List<TaskEntity> tasks;
}
