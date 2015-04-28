package com.Custom;

import com.DAO.Product;
import com.DAO.Reviews;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryCustom {

//    List<Reviews> getReviews(String product_id);

    Product getProduct(String product_id);
}
