package com.inventoryControl.controllers.seller;

import com.inventoryControl.domain.Seller;
import com.inventoryControl.service.seller.ISellerService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@Api(value = "seller")
public class SellerController {

    private final ISellerService sellerService;

    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public ResponseEntity<Seller> createSeller(@Validated @RequestBody SellerModel sellerModel) {
        return ResponseEntity.ok(sellerService.saveSeller(sellerModel));
    }

    @GetMapping
    public ResponseEntity<List<SellerViewModel>> getAllSellers() {
        return ResponseEntity.ok(sellerService.getAll());
    }

    @GetMapping("verifyExistenceOf/{cpf}")
    public ResponseEntity<String> verifyExistenceOfCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(sellerService.verifyExistenceOfCpf(cpf));
    }

}
