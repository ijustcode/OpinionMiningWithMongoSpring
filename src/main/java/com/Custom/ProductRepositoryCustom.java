package com.Custom;

import com.DAO.Product;
import com.mongodb.DBObject;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositoryCustom {

//    List<Reviews> getReviews(String product_id);

    Product getProduct(String product_id);

    Product getCategoryReviewCount(String category) throws Exception;

    Iterable<DBObject> getTotalCountPerCategory();

    Iterable<DBObject> getTop10HighestSentimentBrands();
}
