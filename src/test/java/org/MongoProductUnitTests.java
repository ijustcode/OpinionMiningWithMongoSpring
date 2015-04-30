package org;

import com.Custom.ProductRepositoryCustom;
import com.DAO.Product;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import junit.textui.TestRunner;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by Pouya on 4/30/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class MongoProductUnitTests extends MongoOperations {

    @Autowired
    private ProductRepositoryCustom productRepositoryCustom;

    @Autowired
    MongoOperations mongoOperations;

    @Test
    public void findAndModifyShouldNotBumpVersionByOneWhenVersionFieldAlreadyIncludedInUpdate() {

//        VersionedEntity v = new VersionedEntity();
//        v.id = 1;
//        v.version = 0;
        String product_id = "B000063ILH";

//        Product product = new Product();
//        product.setProduct_id("BL000skj");
//        product.setBrand("Navy");
//        ArgumentCaptor<DBObject> captor = ArgumentCaptor.forClass(DBObject.class);

        Product product = productRepositoryCustom.getProduct(product_id);
        Assert.assertTrue(product.getCategory().equalsIgnoreCase("Electronics"));

    }

}
