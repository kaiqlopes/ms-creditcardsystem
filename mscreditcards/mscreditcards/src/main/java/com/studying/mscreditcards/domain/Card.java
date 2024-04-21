package com.studying.mscreditcards.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Card(String name, CardFlag flag, BigDecimal income, BigDecimal basicLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.basicLimit = basicLimit;
    }
}
