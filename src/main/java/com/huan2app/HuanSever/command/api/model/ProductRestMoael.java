package com.huan2app.HuanSever.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRestMoael {
    private String name;
    private BigDecimal price;
    private  Integer quantity;
}
