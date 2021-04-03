package com.inventoryControl.controllers.folder.profiles;

import com.inventoryControl.controllers.folder.models.FolderModel;
import com.inventoryControl.domain.folder.Folder;
import org.modelmapper.ModelMapper;

public class FolderProfile {
    public static void profile(ModelMapper modelMapper) {
        modelMapper.typeMap(FolderModel.class, Folder.class)
                .addMappings(mapper -> {
                   mapper.map(FolderModel::getFolderProductModelList, Folder::setFolderProducts);
                });
    }
}
