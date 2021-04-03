package com.inventoryControl.repository.folder;

import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;

public class CustomFolderRepository implements ICustomFolderRepository {

    public int getLastInsertedNumber() {
        final Query query = new Query();

        Criteria criteria = new Criteria();

    }

}
