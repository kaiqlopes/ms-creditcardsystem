package com.studying.mscreditevaluator.application.controller;

import com.studying.mscreditevaluator.application.services.CreditEvaluatorService;
import com.studying.mscreditevaluator.domain.model.ClientSituation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<ClientSituation> getClientSituation(@RequestParam("cpf") String cpf) {
        ClientSituation result = creditEvaluatorService.getClientSituation(cpf);
    }

}
