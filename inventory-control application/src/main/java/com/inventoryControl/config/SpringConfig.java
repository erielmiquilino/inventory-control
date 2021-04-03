package com.inventoryControl.config;

import com.inventoryControl.controllers.folder.profiles.FolderProfile;
import com.inventoryControl.controllers.seller.profiles.SellerProfile;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
        SellerProfile.profile(modelMapper);
        FolderProfile.profile(modelMapper);
        return modelMapper;
    }
}
