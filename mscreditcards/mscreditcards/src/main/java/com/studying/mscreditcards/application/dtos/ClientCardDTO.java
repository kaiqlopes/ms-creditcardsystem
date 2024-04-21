package com.studying.mscreditcards.application.dtos;

import com.studying.mscreditcards.domain.Card;
import com.studying.mscreditcards.domain.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCardDTO {

    private String name;
    private String flag;
    private BigDecimal permittedLimit;

    public static ClientCardDTO modelToDTO(ClientCard model) {
        return new ClientCardDTO(
                model.getCard().getName(),
                model.getCard().getFlag().toString(),
                model.getCard().getBasicLimit()
        );
    }
}
