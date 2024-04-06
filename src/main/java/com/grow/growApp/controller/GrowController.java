package com.grow.growApp.controller;

import com.grow.growApp.model.StockData;
import com.grow.growApp.service.GrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grow")
@CrossOrigin("http://localhost:3000")
public class GrowController {

    @Autowired
    private final GrowService stockDataService;

    public GrowController(GrowService stockDataService) {
        this.stockDataService = stockDataService;
    }

    @GetMapping("/closingPriceRange")
    public ResponseEntity<List<StockData>> getStocksByClosingPriceRange(
            @RequestParam double minClosingPrice,
            @RequestParam double maxClosingPrice) {
        List<StockData> stocks = stockDataService.findStocksByClosingPriceRange(minClosingPrice, maxClosingPrice);
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/marketCapRange")
    public ResponseEntity<List<StockData>> getStocksByMarketCapRange(
            @RequestParam double minMarketCap,
            @RequestParam double maxMarketCap) {
        List<StockData> stocks = stockDataService.findStocksByMarketCapRange(minMarketCap, maxMarketCap);
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<StockData>> searchStocksByCompanyName(@RequestParam String companyName) {
        List<StockData> stocks = stockDataService.findStocksByCompanyName(companyName);
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/getAllStocks")
    public ResponseEntity<List<StockData>> getAllStocks() {
        List<StockData> stocks = stockDataService.findAllStocks();
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

}
