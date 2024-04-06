package com.grow.growApp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
@Data
public class StockData {

    @Id
    private String id;
    private String isin;
    private String growwContractId;
    private String companyName;
    private String companyShortName;
    private String searchId;
    private int industryCode;
    private int bseScriptCode;
    private String nseScriptCode;
    private double yearlyHighPrice;
    private double yearlyLowPrice;
    private double closePrice;
    private long marketCap;
    private String livePriceDto;

}
