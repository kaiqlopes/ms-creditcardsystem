package com.studying.mscreditcards.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studying.mscreditcards.application.dtos.CardIssuanceSolicitationDataDTO;
import com.studying.mscreditcards.domain.Card;
import com.studying.mscreditcards.domain.ClientCard;
import com.studying.mscreditcards.infra.repositories.CardRepository;
import com.studying.mscreditcards.infra.repositories.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {

    private final ObjectMapper objectMapper;
    private final CardRepository cardRepository;
    private final ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void issuanceSolicitationReceiver(@Payload String payload) {
        try {
            CardIssuanceSolicitationDataDTO data = objectMapper.readValue(payload, CardIssuanceSolicitationDataDTO.class);
            Card card = cardRepository.findById(data.getCardId()).orElseThrow();

            ClientCard clientCard = new ClientCard(data.getCpf(), card, data.getPermittedLimit());
            clientCardRepository.save(clientCard);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
