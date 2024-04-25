package com.studying.mscreditevaluator.application.services;

import com.studying.mscreditevaluator.application.dtos.*;
import com.studying.mscreditevaluator.application.exceptions.MicroservicesCommunicationException;
import com.studying.mscreditevaluator.application.exceptions.ResourceNotFoundException;
import com.studying.mscreditevaluator.infra.Clients.CardControllerClient;
import com.studying.mscreditevaluator.infra.Clients.ClientControllerClient;
import feign.FeignException;
import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditEvaluatorService {

    private final ClientControllerClient clientControllerClient;
    private final CardControllerClient cardControllerClient;

    public ClientSituationDTO getClientSituation(String cpf) {
        try {
            ResponseEntity<ClientDTO> clientResponse = clientControllerClient.findByCpf(cpf);
            ResponseEntity<List<ClientCardDTO>> clientCardResponse = cardControllerClient.getCardsByCpf(cpf);

            return ClientSituationDTO.builder()
                    .client(clientResponse.getBody())
                    .cards(clientCardResponse.getBody())
                    .build();

        } catch (FeignException.FeignClientException e) {
            throw new ResourceNotFoundException("Resource not found with this CPF: " + cpf);
        } catch (FeignException.ServiceUnavailable e) {
            throw new MicroservicesCommunicationException("Responsible microservice is offline");
        }
    }

    public EvaluatedClientResultDTO evaluateClient(String cpf, Long income) {
        try {
            ResponseEntity<ClientDTO> clientResponse = clientControllerClient.findByCpf(cpf);
            ResponseEntity<List<CardDTO>> cardsResponse = cardControllerClient.getCardsBasedOnIncome(income);

            List<CardDTO> cards = cardsResponse.getBody();
            List<ClientCardDTO> clientCard = cards.stream().map(card -> {
                BigDecimal limit = card.getLimit();
                BigDecimal age = BigDecimal.valueOf(clientResponse.getBody().getAge());
                BigDecimal factor = age.divide(BigDecimal.valueOf(12));
                BigDecimal approvedLimit = factor.multiply(limit);

                return new ClientCardDTO(card.getName(), card.getFlag(), approvedLimit);
            }).toList();

            return new EvaluatedClientResultDTO(clientCard);

        } catch (FeignException.FeignClientException e) {
            throw new ResourceNotFoundException("Resource not found with this CPF: " + cpf);
        } catch (FeignException.ServiceUnavailable e) {
            throw new MicroservicesCommunicationException("Responsible microservice is offline");
        }
    }
}