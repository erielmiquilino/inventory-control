package com.inventoryControl.domain.folder;

import com.inventoryControl.domain.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FolderProduct {

    private ProductType productType;

    private String reference;

    private BigDecimal quantity;

    private BigDecimal unitValue;

    private BigDecimal totalValue;
}
