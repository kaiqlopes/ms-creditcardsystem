package com.studying.mscreditevaluator.infra.Clients;

import com.studying.mscreditevaluator.application.dtos.CardDTO;
import com.studying.mscreditevaluator.application.dtos.ClientCardDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscreditcards", path = "/cards")
public interface CardControllerClient {

    @GetMapping(value = "/get", params = "cpf")
    ResponseEntity<List<ClientCardDTO>> getCardsByCpf(@RequestParam("cpf") String cpf);

    @GetMapping(value = "/get")
    public ResponseEntity<List<CardDTO>> getCardsBasedOnIncome(@RequestParam("income") Long income);
}
