package com.inventoryControl.controllers.seller.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SellerModel {

    private String id;

    private String cpf;

    private String name;

    private String cellphone;

    private String alternativePhone;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private String cep;

    private String complement;

}
