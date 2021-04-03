package com.inventoryControl.service.seller;

import com.inventoryControl.controllers.seller.models.SellerModel;
import com.inventoryControl.controllers.seller.models.SellerViewModel;
import com.inventoryControl.controllers.seller.models.DocumentFileModel;
import com.inventoryControl.domain.seller.Address;
import com.inventoryControl.domain.seller.Seller;
import com.inventoryControl.domain.enums.FileType;
import com.inventoryControl.repository.seller.SellerRepository;
import com.inventoryControl.service.GoogleStorageAppService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Collectors;

@Service
public class SellerService implements ISellerService{

    private final SellerRepository sellerRepository;
    private final GoogleStorageAppService googleStorageAppService;
    private final ModelMapper modelMapper;

    public SellerService(SellerRepository sellerRepository, GoogleStorageAppService googleStorageAppService, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.googleStorageAppService = googleStorageAppService;
        this.modelMapper = modelMapper;
    }

    public Seller saveSeller(SellerModel sellerModel) {
        var seller = modelMapper.map(sellerModel, Seller.class);
        seller.setAddress(modelMapper.map(sellerModel, Address.class));

        return sellerRepository.save(seller);
    }

    public Page<SellerViewModel> getPaginatedSellers(int pageNumber, int pageSize, String key) {
        var pageable = PageRequest.of(pageNumber, pageSize);

        var sellers = sellerRepository.findSellerByKey(key, pageable).stream()
                .map(seller -> modelMapper.map(seller, SellerViewModel.class))
                .collect(Collectors.toList());

        var totalRows = sellerRepository.count();

        return new PageImpl<>(sellers, pageable, totalRows);
    }

    public boolean verifyExistenceOfCpf(String cpf) {
        return sellerRepository.existsByCpf(cpf);
    }

    public SellerModel getSellerById(String id) {
        var seller = sellerRepository.findById(id)
                .orElseThrow();

        var sellerModel = modelMapper.map(seller, SellerModel.class);
        modelMapper.map(seller.getAddress(), sellerModel);

        return sellerModel;
    }

    public Seller updateSeller(SellerModel sellerModel) {
        return saveSeller(sellerModel);
    }

    public void deleteSeller(String id) {
        sellerRepository.deleteById(id);
    }

    public DocumentFileModel saveFile(MultipartFile file, FileType fileType) throws IOException {
        return googleStorageAppService.save(file, fileType);
    }
}
