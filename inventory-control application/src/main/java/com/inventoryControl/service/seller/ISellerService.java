package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.SellerModel;
import com.inventoryControl.domain.Seller;

public interface ISellerService {

    Seller saveSeller(SellerModel sellerModel);

}
