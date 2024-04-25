package com.studying.mscreditevaluator.application.dtos;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CardDTO {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal income;
    private BigDecimal limit;

}
