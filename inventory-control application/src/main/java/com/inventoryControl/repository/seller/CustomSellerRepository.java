package com.inventoryControl.repository.seller;

import com.inventoryControl.domain.seller.Seller;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomSellerRepository implements ICustomSellerRepository {

    private final MongoTemplate mongoTemplate;

    public CustomSellerRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Seller> findSellerByKey(String key, PageRequest pageable) {
        final Query query = new Query()
                .with(pageable);

        if (key != null && !key.isEmpty())
        {
            Criteria criteria = new Criteria();
            criteria.orOperator(Criteria.where("Name").regex(key),
                    Criteria.where("address.city").regex(key),
                    Criteria.where("address.state").regex(key),
                    Criteria.where("cpf").regex(key),
                    Criteria.where("cellphone").regex(key));

            query.addCriteria(criteria);
        }

        return mongoTemplate.find(query, Seller.class);
    }

}
