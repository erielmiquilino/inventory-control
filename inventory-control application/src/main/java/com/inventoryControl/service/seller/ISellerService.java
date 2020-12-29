package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.models.SellerModel;
import com.inventoryControl.controllers.seller.models.SellerViewModel;
import com.inventoryControl.domain.Seller;

import java.util.List;

public interface ISellerService {

    Seller saveSeller(SellerModel sellerModel);

    List<SellerViewModel> getAll();

    boolean verifyExistenceOfCpf(String cpf);

    SellerModel getSellerById(String id);
}
