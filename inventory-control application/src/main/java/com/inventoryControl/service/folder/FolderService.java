package com.inventoryControl.service.folder;

import com.inventoryControl.controllers.folder.models.FolderModel;
import com.inventoryControl.domain.folder.Folder;
import com.inventoryControl.repository.folder.FolderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class FolderService implements IFolderService {

    private final FolderRepository folderRepository;
    private final ModelMapper modelMapper;

    public FolderService(FolderRepository folderRepository, ModelMapper modelMapper) {
        this.folderRepository = folderRepository;
        this.modelMapper = modelMapper;
    }

    public Folder saveFolder(FolderModel folderModel) {
        var folder = modelMapper.map(folderModel, Folder.class);

        folder.setNumber();

    }
}
