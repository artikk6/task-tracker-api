package com.github.task.tracker.store.repository;

import com.github.task.tracker.store.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query(value = "SELECT * FROM task WHERE id = ? AND folder_id = ?", nativeQuery = true)
    Optional<TaskEntity> findByIdAndFolderId(Long taskID, Long folderID);
}
