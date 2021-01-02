package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.models.SellerModel;
import com.inventoryControl.controllers.seller.models.SellerViewModel;
import com.inventoryControl.domain.Seller;
import org.springframework.data.domain.Page;

public interface ISellerService {

    Seller saveSeller(SellerModel sellerModel);

    Page<SellerViewModel> getPaginatedSellers(int pageNumber, int pageSize, String key);

    boolean verifyExistenceOfCpf(String cpf);

    SellerModel getSellerById(String id);

    Seller updateSeller(SellerModel sellerModel);

    void deleteSeller(String id);
}
