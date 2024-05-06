package com.studying.mscreditcards.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Data
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    private BigDecimal clientLimit;

    public ClientCard(String cpf, Card card, BigDecimal clientLimit) {
        this.cpf = cpf;
        this.card = card;
        this.clientLimit = clientLimit;
    }
}
