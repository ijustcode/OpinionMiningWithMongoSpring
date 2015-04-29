package com.Custom;

import com.DAO.Product;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepositoryCustom {

//    List<Reviews> getReviews(String product_id);

    Product getProduct(String product_id);

    Product getCategoryReviewCount(String category) throws Exception;
}
