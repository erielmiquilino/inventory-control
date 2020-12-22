package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.SellerModel;
import com.inventoryControl.controllers.seller.SellerViewModel;
import com.inventoryControl.domain.Seller;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISellerService {

    Seller saveSeller(SellerModel sellerModel);

    List<SellerViewModel> getAll();
}
