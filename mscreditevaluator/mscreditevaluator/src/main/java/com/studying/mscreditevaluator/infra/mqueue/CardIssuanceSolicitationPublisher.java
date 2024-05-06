package com.studying.mscreditevaluator.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studying.mscreditevaluator.application.dtos.CardIssuanceSolicitationDataDTO;
import com.studying.mscreditevaluator.application.exceptions.JsonConvertionException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CardIssuanceSolicitationPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue cardIssuanceQueue;
    private final ObjectMapper objectMapper;

    public void cardSolicitation(CardIssuanceSolicitationDataDTO data) {
        try {
            String json = convertIntoJson(data);
            rabbitTemplate.convertAndSend(cardIssuanceQueue.getName(), json);
        } catch (JsonProcessingException e) {
            throw new JsonConvertionException("Error converting json at card solicitation");
        }
    }

    private String convertIntoJson(CardIssuanceSolicitationDataDTO data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(data);

    }
}
