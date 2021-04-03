package com.inventoryControl.controllers.folder.models;

import com.inventoryControl.domain.enums.ProductType;

import java.math.BigDecimal;

public class FolderProductModel {

    private ProductType productType;

    private String reference;

    private BigDecimal quantity;

    private BigDecimal unitValue;

    private BigDecimal totalValue;

}
