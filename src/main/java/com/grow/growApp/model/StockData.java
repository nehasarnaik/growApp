package com.grow.growApp.model;

import lombok.Data;

@Data
public class StockData {
    private double currentPrice;
    private double low;
    private double high;
    private double prevClose;
}
