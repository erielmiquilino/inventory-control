package com.inventoryControl.controllers.seller;

import com.inventoryControl.controllers.seller.models.SellerModel;
import com.inventoryControl.controllers.seller.models.SellerViewModel;
import com.inventoryControl.controllers.seller.models.DocumentFileModel;
import com.inventoryControl.domain.seller.Seller;
import com.inventoryControl.domain.enums.FileType;
import com.inventoryControl.service.seller.ISellerService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.IOException;

@RestController
@RequestMapping("/seller")
@Api(value = "seller")
public class SellerController {

    private final ISellerService sellerService;

    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("save")
    public ResponseEntity<Seller> createSeller(@Validated @RequestBody SellerModel sellerModel) {
        return ResponseEntity.ok(sellerService.saveSeller(sellerModel));
    }

    @GetMapping("getPaginated/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<SellerViewModel>> getPaginatedSellers(@PathVariable int pageNumber, @PathVariable int pageSize, String key) {
        return ResponseEntity.ok(sellerService.getPaginatedSellers(pageNumber, pageSize, key));
    }

    @GetMapping("verifyExistenceOf/{cpf}")
    public ResponseEntity<Boolean> verifyExistenceOfCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(sellerService.verifyExistenceOfCpf(cpf));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<SellerModel> getSellerById(@PathVariable String id) {
        return ResponseEntity.ok(sellerService.getSellerById(id));
    }

    @PutMapping("update")
    public ResponseEntity<Seller> updateSeller(@Validated @RequestBody SellerModel sellerModel) {
        return ResponseEntity.ok(sellerService.updateSeller(sellerModel));
    }

    @DeleteMapping("delete/{id}")
    public void deleteSeller(@PathVariable String id) {
        sellerService.deleteSeller(id);
    }

    @PostMapping("uploadDocument/{fileType}")
    public DocumentFileModel uploadFrontDocument(@RequestParam("file") MultipartFile file, @PathVariable FileType fileType)
            throws ServletException, IOException {
        return sellerService.saveFile(file, fileType);
    }

}
