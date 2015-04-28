package com.Implementation;

import com.Custom.ProductRepositoryCustom;
import com.DAO.Product;
import com.DAO.Reviews;
import com.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @Autowired
    MongoOperations mongoOperations;

    public static final String COLLECTION_NAME = "products";

    @Override
    public Product getProduct(String product_id) {

        Query getReviewsQuery = new Query();
        getReviewsQuery.addCriteria((Criteria.where("_id").is(product_id)));

        Product productQuery = mongoOperations.findOne(getReviewsQuery, Product.class, COLLECTION_NAME);

        return productQuery;
    }
}
