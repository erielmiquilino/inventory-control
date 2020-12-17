package com.inventoryControl.controllers.seller;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SellerModel {

    private String cpf;

    private String name;

    private String cellphone;

    private String alternativePhone;

    private String email;

    private LocalDate dateOfBirth;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String cep;

    private String complement;

}
