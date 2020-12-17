package com.inventoryControl.controllers.seller;

import com.inventoryControl.domain.Seller;
import com.inventoryControl.service.seller.ISellerService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@Api(value = "seller")
public class SellerController {

    private final ISellerService sellerService;

    public SellerController(ISellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public Seller createSeller(@Validated @RequestBody SellerModel sellerModel) {
        return sellerService.saveSeller(sellerModel);
    }



}
