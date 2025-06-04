package com.github.task.tracker.api.controller;


import com.github.task.tracker.api.dto.FolderDto;
import com.github.task.tracker.api.service.FolderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class FolderController {
    private final FolderService folderService;

    private static final String CREATE_FOLDER = "/create_folder";
    private static final String FIND_ALL_FOLDERS = "/folders";
    private static final String FIND_FOLDER = "/folder/{id}";

    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }
    @GetMapping(FIND_FOLDER)
    public FolderDto folderDto(@PathVariable("id") Long id) {
        return folderService.findFolder(id);
    }

    @GetMapping(FIND_ALL_FOLDERS)
    public List<FolderDto> findAllFolders() {
        return folderService.findAllFolders();
    }

    @PostMapping(CREATE_FOLDER)
    @ResponseStatus(HttpStatus.CREATED)
    public FolderDto createFolder(@RequestParam String name) {
        return folderService.createFolder(name);
    }
}