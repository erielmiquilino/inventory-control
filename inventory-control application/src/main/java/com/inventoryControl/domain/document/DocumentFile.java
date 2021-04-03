package com.inventoryControl.domain.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentFile {
    private String fileName;

    private String fileDownloadUri;
}
