package com.studying.mscreditevaluator.application.controller;

import com.studying.mscreditevaluator.application.dtos.*;
import com.studying.mscreditevaluator.application.services.CreditEvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/credit-evaluator")
@RequiredArgsConstructor
public class CreditEvaluatorController {

    private final CreditEvaluatorService creditEvaluatorService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "client-situation")
    public ResponseEntity<ClientSituationDTO> getClientSituation(@RequestParam("cpf") String cpf) {
        ClientSituationDTO result = creditEvaluatorService.getClientSituation(cpf);

        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/evaluate-client")
    public ResponseEntity<EvaluatedClientResultDTO> evaluateClient(@RequestBody EvaluationDataDTO dto) {
        EvaluatedClientResultDTO evaluatedClientResult = creditEvaluatorService.evaluateClient(dto.getCpf(), dto.getIncome());

        return ResponseEntity.ok(evaluatedClientResult);
    }

    @PostMapping(value = "request-card")
    public ResponseEntity<CardSolicitationProtocol> requestCard(@RequestBody CardIssuanceSolicitationDataDTO data) {
        CardSolicitationProtocol protocol = creditEvaluatorService.cardIssuanceSolicitation(data);
        return ResponseEntity.ok(protocol);
    }

}
