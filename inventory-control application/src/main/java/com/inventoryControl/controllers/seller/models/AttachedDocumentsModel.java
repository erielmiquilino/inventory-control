package com.inventoryControl.controllers.seller.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachedDocumentsModel {

    private DocumentFileModel frontDocument;

    private DocumentFileModel backDocument;

    private DocumentFileModel proofResidence;

}
