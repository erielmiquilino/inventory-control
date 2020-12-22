package com.inventoryControl.controllers.seller;

import com.inventoryControl.domain.Seller;
import com.inventoryControl.service.seller.ISellerService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

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

}
