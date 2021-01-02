package com.inventoryControl.repository.seller;

import com.inventoryControl.domain.Seller;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CustomSellerRepository {

    List<Seller> findSellerByKey(String key, PageRequest pageable);

}
