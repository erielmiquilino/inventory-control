package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.models.SellerModel;
import com.inventoryControl.controllers.seller.models.SellerViewModel;
import com.inventoryControl.controllers.seller.models.DocumentFileModel;
import com.inventoryControl.domain.seller.Seller;
import com.inventoryControl.domain.enums.FileType;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;

public interface ISellerService {

    Seller saveSeller(SellerModel sellerModel);

    Page<SellerViewModel> getPaginatedSellers(int pageNumber, int pageSize, String key);

    boolean verifyExistenceOfCpf(String cpf);

    SellerModel getSellerById(String id);

    Seller updateSeller(SellerModel sellerModel);

    void deleteSeller(String id);

    DocumentFileModel saveFile(MultipartFile file, FileType frontDocument) throws ServletException, IOException;
}
