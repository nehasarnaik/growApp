package com.grow.growApp.repository;

import com.grow.growApp.model.StockData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface mongoRepo extends MongoRepository<StockData,String> {
    @Query("{'closePrice': { $gte: ?0, $lte: ?1 } }")
    List<StockData> findByClosePriceBetween(double minClosingPrice, double maxClosingPrice);

    List<StockData> findByCompanyName(String companyName);

    List<StockData> findByMarketCapBetween(double minMarketCap, double maxMarketCap);
}
