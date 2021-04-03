package com.inventoryControl.domain.folder;

import com.inventoryControl.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Folder extends BaseEntity {

    private int number;

    private String sellerName;

    private List<FolderProduct> folderProducts;

}
