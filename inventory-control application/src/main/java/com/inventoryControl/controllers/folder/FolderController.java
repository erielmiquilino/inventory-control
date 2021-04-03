package com.inventoryControl.controllers.folder;

import com.inventoryControl.controllers.folder.models.FolderModel;
import com.inventoryControl.domain.folder.Folder;
import com.inventoryControl.service.folder.IFolderService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/folder")
@Api(value = "folder")
public class FolderController {

    private final IFolderService folderService;

    public FolderController(IFolderService folderService) {
        this.folderService = folderService;
    }


    public ResponseEntity<Folder> createFolder(@Validated @RequestBody FolderModel folderModel) {
        return ResponseEntity.ok(folderService.saveFolder(folderModel));
    }

}
