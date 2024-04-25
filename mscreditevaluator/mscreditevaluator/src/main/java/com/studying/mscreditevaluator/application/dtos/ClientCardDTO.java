package com.studying.mscreditevaluator.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ClientCardDTO {

    private String name;
    private String flag;
    private BigDecimal permittedLimit;


}
