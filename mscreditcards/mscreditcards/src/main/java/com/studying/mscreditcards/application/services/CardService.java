package com.studying.mscreditcards.application.services;

import com.studying.mscreditcards.application.dtos.CardDTO;
import com.studying.mscreditcards.application.dtos.CardSaveDTO;
import com.studying.mscreditcards.domain.Card;
import com.studying.mscreditcards.infra.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public CardDTO save(CardSaveDTO dto) {
        Card entity = dto.toModel();
        entity = repository.save(entity);
        return new CardDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CardDTO> getCardsBasedOnIncome(Long income) {
        BigDecimal bigDecimalIncome = BigDecimal.valueOf(income);
        List<Card> result = repository.findByIncomeLessThanEqual(bigDecimalIncome);
        return result.stream().map(CardDTO::new).toList();
    }

}
