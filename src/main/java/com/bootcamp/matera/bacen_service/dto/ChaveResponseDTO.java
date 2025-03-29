package com.bootcamp.matera.bacen_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// classe DTO para transferir os dados entre a API e o banco de dados

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ChaveResponseDTO {
    private String chave;
    private Boolean ativa;
}
