package com.inventoryControl.controllers.seller.profiles;

import com.inventoryControl.controllers.seller.models.SellerModel;
import com.inventoryControl.controllers.seller.models.SellerViewModel;
import com.inventoryControl.domain.Seller;
import org.modelmapper.ModelMapper;

public class SellerProfile {
    public static void profile(ModelMapper modelMapper) {
        modelMapper.typeMap(Seller.class, SellerViewModel.class)
                .addMappings(mapper -> {
                   mapper.map(src -> src.getAddress().getCity(), SellerViewModel::setCity);
                   mapper.map(src -> src.getAddress().getState(), SellerViewModel::setState);
                });

        modelMapper.typeMap(SellerModel.class, Seller.class)
                .addMapping(SellerModel::getDateOfBirth, Seller::setDateOfBirth);
    }
}
