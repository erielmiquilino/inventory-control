package com.inventoryControl.service.folder;

import com.inventoryControl.controllers.folder.models.FolderModel;
import com.inventoryControl.domain.folder.Folder;

public interface IFolderService {
    Folder saveFolder(FolderModel folderModel);
}
