package com.grow.growApp.controller;

import com.grow.growApp.dto.StockWithPriceDTO;
import com.grow.growApp.service.GrowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grow")
@AllArgsConstructor
public class GrowController {

    private final GrowService growService;
    @GetMapping("/popularStocks")
    public List<StockWithPriceDTO> getPopularStocks(){
        return growService.getPopularStocks();
    }


}
