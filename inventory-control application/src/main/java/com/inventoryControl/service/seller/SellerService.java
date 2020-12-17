package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.SellerModel;
import com.inventoryControl.domain.Address;
import com.inventoryControl.domain.Seller;
import com.inventoryControl.repository.SellerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements ISellerService{

    private final SellerRepository sellerRepository;

    private final ModelMapper modelMapper;

    public SellerService(SellerRepository sellerRepository, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
    }

    public Seller saveSeller(SellerModel sellerModel) {
        var seller = modelMapper.map(sellerModel, Seller.class);

        seller.setAddress(modelMapper.map(sellerModel, Address.class));

        return sellerRepository.save(seller);
    }
}
