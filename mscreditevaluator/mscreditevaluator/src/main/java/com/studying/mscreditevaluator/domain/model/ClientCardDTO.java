package com.studying.mscreditevaluator.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClientCardDTO {

    private String name;
    private String flag;
    private BigDecimal permittedLimit;

}
