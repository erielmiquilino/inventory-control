package com.inventoryControl.domain;

import com.inventoryControl.domain.base.BaseEntity;
import com.inventoryControl.domain.enums.ProductType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
public class Product extends BaseEntity {

    private String code;

    private BigDecimal Value;

    private ProductType productType;

}
