package com.inventoryControl.domain.seller;

import com.inventoryControl.domain.base.BaseEntity;
import com.inventoryControl.domain.document.AttachedDocuments;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Seller extends BaseEntity {

    private String cpf;

    private String name;

    private String cellphone;

    private String alternativePhone;

    private String email;

    private LocalDate dateOfBirth;

    private Address address;

    private AttachedDocuments attachedDocuments;
}
