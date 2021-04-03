package com.inventoryControl.repository.seller;

import com.inventoryControl.domain.seller.Seller;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICustomSellerRepository {

    List<Seller> findSellerByKey(String key, PageRequest pageable);

}
