package com.spring.batch.demo.csv;

import lombok.Data;

@Data
public class MarketDataPojo {
    private Integer id;
    private String ticker;
    private String description;
}
