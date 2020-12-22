package com.inventoryControl.controllers.seller.profiles;

import com.inventoryControl.controllers.seller.SellerViewModel;
import com.inventoryControl.domain.Seller;
import org.modelmapper.ModelMapper;

import javax.print.attribute.standard.Destination;

public class SellerProfile {
    public static void profile(ModelMapper modelMapper) {
        modelMapper.typeMap(Seller.class, SellerViewModel.class)
                .addMappings(mapper -> {
                   mapper.map(src -> src.getAddress().getCity(), SellerViewModel::setCity);
                   mapper.map(src -> src.getAddress().getState(), SellerViewModel::setState);
                });
    }
}
