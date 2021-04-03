package com.inventoryControl.domain.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachedDocuments {
    private DocumentFile frontDocument;

    private DocumentFile backDocument;

    private DocumentFile proofResidence;
}
