package com;


import com.Custom.ProductRepositoryCustom;
import com.DAO.Product;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulController {

    @Autowired
    private ProductRepositoryCustom productRepositoryCustom;

    @Autowired
    MongoOperations mongoOperations;

    @RequestMapping(value = "api/v1/productReviews/{product_id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String product_id) {

        return productRepositoryCustom.getProduct(product_id);


//        Product product = (Product) productRepository.findByProduct_id(product_id);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("_id", product.getProduct_id());
//        jsonObject.put("brand", product.getBrand());
//        jsonObject.put("category", product.getCategory());
//        jsonObject.put("price", product.getPrice());
//        JSONArray array = new JSONArray();
//        for ( Reviews reviewsJson : product.getReviews()) {
//            JSONObject arrayElementOne = new JSONObject();
//            arrayElementOne.put("score", reviewsJson.getScore());
//            arrayElementOne.put("user_id", reviewsJson.getUser_id());
//            arrayElementOne.put("sentiment", reviewsJson.getSentiment());
//            arrayElementOne.put("text", reviewsJson.getText());
//            array.put(arrayElementOne);
//        }
//        jsonObject.put("reviews", array);
//        String textOutput = jsonObject.toString();
//
//        return jsonObject;
    }


    @RequestMapping(value = "api/v1/productReviewsTest/{category}", method = RequestMethod.GET)
    public Product getCategoryReviewCount(@PathVariable String category) throws Exception {

        return productRepositoryCustom.getCategoryReviewCount(category);
    }

    @RequestMapping(value = "api/v1/getTotalCountPerCategory", method = RequestMethod.GET)
    public Iterable<DBObject> getTotalCountPerCategory() {
        return productRepositoryCustom.getTotalCountPerCategory();
    }

    @RequestMapping(value = "api/v1/getTop10HighestSentimentBrands", method = RequestMethod.GET)
    public Iterable<DBObject> getTop10HighestSentimentBrands() {
        return productRepositoryCustom.getTop10HighestSentimentBrands();
    }


}
