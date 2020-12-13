package com.inventoryControl.domain;

import com.inventoryControl.domain.base.BaseEntity;
import com.inventoryControl.domain.enums.ProductType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    private String code;

    private BigDecimal Value;

    private ProductType productType;

}
