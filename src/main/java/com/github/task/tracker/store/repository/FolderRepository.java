package com.github.task.tracker.store.repository;

import com.github.task.tracker.store.entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<FolderEntity, Long> {
}
