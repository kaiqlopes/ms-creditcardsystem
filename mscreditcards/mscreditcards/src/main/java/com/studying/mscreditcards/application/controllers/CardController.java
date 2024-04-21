package com.studying.mscreditcards.application.controllers;

import com.studying.mscreditcards.application.dtos.CardDTO;
import com.studying.mscreditcards.application.dtos.CardSaveDTO;
import com.studying.mscreditcards.application.dtos.ClientCardDTO;
import com.studying.mscreditcards.application.services.CardService;
import com.studying.mscreditcards.application.services.ClientCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cards")
public class CardController {

    private final CardService cardService;
    private final ClientCardService clientCardService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CardSaveDTO dto){
        cardService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<CardDTO>> getCardsBasedOnIncome(@RequestParam("income") Long income) {
        List<CardDTO> result = cardService.getCardsBasedOnIncome(income);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/get", params = "cpf")
    public ResponseEntity<List<ClientCardDTO>> getCardsByCpf(@RequestParam("cpf") String cpf) {
        List<ClientCardDTO> result = clientCardService.getCardsByCpf(cpf);
        return ResponseEntity.ok(result);
    }
}
