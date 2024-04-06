package com.grow.growApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grow.growApp.dto.StockPrice;
import com.grow.growApp.dto.StockSymbol;
import com.grow.growApp.dto.StockWithPriceDTO;
import com.grow.growApp.model.StockData;
import com.grow.growApp.repository.mongoRepo;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GrowService {


    private final mongoRepo mongoRepo;

    @Autowired
    public GrowService(mongoRepo mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    public List<StockData> findStocksByClosingPriceRange(double minClosingPrice, double maxClosingPrice) {
        return mongoRepo.findByClosePriceBetween(minClosingPrice, maxClosingPrice);
    }

    public List<StockData> findStocksByCompanyName(String companyName) {
        return mongoRepo.findByCompanyName(companyName);
    }

    public List<StockData> findStocksByMarketCapRange(double minMarketCap, double maxMarketCap) {
        return mongoRepo.findByMarketCapBetween(minMarketCap, maxMarketCap);
    }

    public List<StockData> findAllStocks() {
        return mongoRepo.findAll();
    }

}
