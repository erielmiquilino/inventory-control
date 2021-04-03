package com.inventoryControl.controllers.folder.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FolderModel {

    private String sellerName;

    private List<FolderProductModel> folderProductModelList;

}
