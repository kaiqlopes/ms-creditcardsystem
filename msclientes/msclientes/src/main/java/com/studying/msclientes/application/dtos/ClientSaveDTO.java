package com.studying.msclientes.application.dtos;

import com.studying.msclientes.domain.Client;
import lombok.Data;

@Data
public class ClientSaveDTO {

    private String name;
    private String cpf;
    private Integer age;

    public Client toModel() {
        return new Client(cpf, age, name);
    }
}
