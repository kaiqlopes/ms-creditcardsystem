package com.studying.mscreditcards.application.dtos;

import com.studying.mscreditcards.domain.Card;
import com.studying.mscreditcards.domain.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private Long id;
    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal limit;

    public CardDTO(Card entity) {
        id = entity.getId();
        name = entity.getName();
        flag = entity.getFlag();
        income = entity.getIncome();
        limit = entity.getBasicLimit();
    }

    public Card toModel() {
        return new Card(id, name, flag, income, limit);
    }
}
