package com.studying.mscreditevaluator.infra.clients;

import com.studying.mscreditevaluator.application.dtos.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclients", path = "/clients")
public interface ClientControllerClient {

    @GetMapping(value = "/get")
    ResponseEntity<ClientDTO> findByCpf(@RequestParam("cpf") String cpf);

}
