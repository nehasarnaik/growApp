package com.grow.growApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grow.growApp.dto.StockPrice;
import com.grow.growApp.dto.StockSymbol;
import com.grow.growApp.dto.StockWithPriceDTO;
import com.grow.growApp.model.StockData;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GrowService {

    private static List<StockSymbol> stockSymbols = null;

    public GrowService(){
        stockSymbols = new ArrayList<>();
        stockSymbols.add(StockSymbol.builder().symbol("C").description("CITIGROUP").build());
        stockSymbols.add(StockSymbol.builder().symbol("AAPL").description("APPLE INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("GOOG").description("ALPHABET INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("GOOGL").description("ALPHABET INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("ADBE").description("ADOBE INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("TSLA").description("TESLA INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("WMT").description("WALMART INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("AMZN").description("AMAZON.COM INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("NKE").description("NIKE INC").build());
        stockSymbols.add(StockSymbol.builder().symbol("MCD").description("MCDONALD'S CORP").build());
        stockSymbols.add(StockSymbol.builder().symbol("NVDA").description("NVIDIA CORP").build());
    }

    public List<StockWithPriceDTO> getPopularStocks() {
        List<StockWithPriceDTO> stocks = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        for (StockSymbol stockSymbol : stockSymbols) {
            String uri = String.format("https://finnhub.io/api/v1/quote?symbol=%s&token=%s",stockSymbol.getSymbol(),"co8g4c9r01qg6s17emf0co8g4c9r01qg6s17emfg");
            try {
                StockPrice stockPrice = objectMapper.readValue((new RestTemplate()).getForObject(uri, String.class)
                        , StockPrice.class);
                stocks.add(StockWithPriceDTO.builder().stockSymbol(stockSymbol).stockPrice(stockPrice).build());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return stocks;
    }

    public List<StockData> getAllStocks(){
        String uri = "https://groww.in/v1/api/stocks_data/v1/all_stocks";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JSONArray jsonArray = new JSONArray(result);
        ObjectMapper objectMapper = new ObjectMapper();
        return Collections.emptyList();
    }

}
