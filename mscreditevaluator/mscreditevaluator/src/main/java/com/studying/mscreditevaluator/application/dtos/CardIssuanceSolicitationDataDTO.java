package com.studying.mscreditevaluator.application.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardIssuanceSolicitationDataDTO {

    private Long cardId;
    private String cpf;
    private String address;
    private BigDecimal permittedLimit;

}
