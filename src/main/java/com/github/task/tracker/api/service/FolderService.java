package com.github.task.tracker.api.service;

import com.github.task.tracker.api.dto.FolderDto;
import com.github.task.tracker.api.exception.BadRequestException;
import com.github.task.tracker.api.factory.FolderDtoFactory;
import com.github.task.tracker.store.entity.FolderEntity;
import com.github.task.tracker.store.repository.FolderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FolderService {
    FolderRepository folderRepository;
    FolderDtoFactory folderDtoFactory;

    public FolderService(FolderRepository folderRepository, FolderDtoFactory folderDtoFactory) {
        this.folderRepository = folderRepository;
        this.folderDtoFactory = folderDtoFactory;
    }

    public FolderDto findFolder(Long id) {

        if (folderRepository.findById(id).isEmpty()) {
            throw new BadRequestException("Folder not found");
        }
        return folderDtoFactory.makeFolderDto(
                folderRepository.findById(id).get()
        );
    }

    @Transactional
    public List<FolderDto> findAllFolders() {

        List<FolderDto> folders = folderRepository.findAll().stream()
                .map(folderDtoFactory::makeFolderDto).toList();

        if (folders.isEmpty()) {
            throw new BadRequestException("no folders found");
        }

        return folders;
    }

    @Transactional
    public FolderDto createFolder(String name) {
        if (folderRepository.existsByName(name)) {
            throw new BadRequestException("Folder with this name already exists");
        }

        FolderEntity folder = folderRepository.saveAndFlush(
                FolderEntity.builder()
                        .name(name)
                        .createdAt(LocalDate.now())
                        .build()
        );
        return folderDtoFactory.makeFolderDto(folder);
    }
}
