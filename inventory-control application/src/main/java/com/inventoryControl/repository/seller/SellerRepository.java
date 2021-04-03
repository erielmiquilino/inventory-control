package com.inventoryControl.repository.seller;

import com.inventoryControl.domain.seller.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, String>, ICustomSellerRepository {

    boolean existsByCpf(String cpf);

}
