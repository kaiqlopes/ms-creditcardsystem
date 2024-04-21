package com.studying.mscreditcards.application.dtos;

import com.studying.mscreditcards.domain.Card;
import com.studying.mscreditcards.domain.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveDTO {

    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toModel() {
        return new Card(name, flag, income, limit);
    }
}
