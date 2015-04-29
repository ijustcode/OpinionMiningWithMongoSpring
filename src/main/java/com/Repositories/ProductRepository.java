package com.Repositories;

import com.DAO.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    public static final String COLLECTION_NAME = "products";
//
//    public Product getProduct(String product_id) {
//
//        Query getReviewsQuery = new Query();
//        getReviewsQuery.addCriteria((Criteria.where("_id").is(product_id)));
//
//        Product productQuery = mongoTemplate.findOne(getReviewsQuery, Product.class, COLLECTION_NAME);
//
//
//        return productQuery;
//    }

    public Product findByBrand(String brand);
//    public List<Reviews> findByProduct_id(String product_id);


}