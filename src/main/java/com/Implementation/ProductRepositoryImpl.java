package com.Implementation;

import com.Custom.ProductRepositoryCustom;
import com.DAO.Product;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    @Override
    public Product getCategoryReviewCount(String category) throws Exception {

        List<DBObject> list = new ArrayList<DBObject>();

        DBObject unwindReviews = new BasicDBObject("$unwind", "$reviews");
        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", new BasicDBObject("category", "$category")
                .append("gender", "$reviews.user_gender"))
                .append("count", new BasicDBObject("$sum", Integer.parseInt("1"))));
        list.add(unwindReviews);
        list.add(group);

        AggregationOutput output = null;
        try {
            System.out.println("COLLECTION NAME: " + mongoOperations.getCollection("products").getFullName());
            output = mongoOperations.getCollection("products").aggregate(list);
        } catch (Exception e) {
            System.out.println("CANNOT make the call");
        }
        if (output == null) {
            System.out.println("___output is null");
        } else {
            for (DBObject result : output.results()) {
                System.out.println(result);
            }
        }
        Query getReviewsQuery = new Query();
        getReviewsQuery.addCriteria((Criteria.where("_id").is(category)));

        Product productQuery = mongoOperations.findOne(getReviewsQuery, Product.class, COLLECTION_NAME);


        return productQuery;

    }

    @Override
    public Iterable<DBObject> getTotalCountPerCategory() {

        List<DBObject> list = new ArrayList<>();

        DBObject unwindReviews = new BasicDBObject("$unwind", "$reviews");
        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", new BasicDBObject("category", "$category")
                .append("gender", "$reviews.user_gender"))
                .append("count", new BasicDBObject("$sum", Integer.parseInt("1"))));
        list.add(unwindReviews);
        list.add(group);

        AggregationOutput results = mongoOperations.getCollection("products").aggregate(list);
        Iterable<DBObject> dbObjects = results.results();

        return dbObjects;
    }

    @Override
    public Iterable<DBObject> getTop10HighestSentimentBrands() {

        List<DBObject> list = new ArrayList<>();

        DBObject unwindReviews = new BasicDBObject("$unwind", "$reviews");
        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", new BasicDBObject("brand", "$brand"))
                .append("avg_sentiment", new BasicDBObject("$avg", "$reviews.sentiment")));
        DBObject sort = new BasicDBObject("$sort", new BasicDBObject("avg_sentiment", -1));
        DBObject limit = new BasicDBObject("$limit", 15);

        list.add(unwindReviews);
        list.add(group);
        list.add(sort);
        list.add(limit);

        AggregationOutput results = mongoOperations.getCollection("products").aggregate(list);
        Iterable<DBObject> dbObjects = results.results();

        return dbObjects;
    }
}
