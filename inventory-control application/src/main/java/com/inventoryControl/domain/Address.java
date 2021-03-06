package com.inventoryControl.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String cep;

    private String complement;

}
