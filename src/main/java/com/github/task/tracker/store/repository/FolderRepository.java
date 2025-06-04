package com.github.task.tracker.store.repository;

import com.github.task.tracker.store.entity.FolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<FolderEntity, Long> {

    boolean existsByName(String name);
}
