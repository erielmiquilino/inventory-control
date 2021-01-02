package com.inventoryControl.repository.seller;

import com.inventoryControl.domain.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SellerRepository extends MongoRepository<Seller, String>, CustomSellerRepository {

    boolean existsByCpf(String cpf);

}
