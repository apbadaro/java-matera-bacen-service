package com.bootcamp.matera.bacen_service.service;

import com.bootcamp.matera.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.matera.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.matera.bacen_service.model.Chave;
import com.bootcamp.matera.bacen_service.repository.ChaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

// classe service para manipular os dados do banco de dados

@RequiredArgsConstructor // Gera um construtor para fazer a injeção de dependência ChaveRepository
@Component
public class ChaveService {

    private final ChaveRepository chaveRepository; // Injeção de dependência do repositório

    // Método para criar uma nova chave
    public ChaveResponseDTO criarChave(final ChaveRequestDTO chaveRequestDTO) {
        Chave chave = Chave.builder() // Cria um novo objeto Chave
                .chave(chaveRequestDTO.getChave())
                .ativa(chaveRequestDTO.getAtiva())
                .build();

        chave = chaveRepository.save(chave); // Salva a chave criada no banco de dados

        // Retorna a chave criada
        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

    // Método para buscar uma chave pelo ID
    public ChaveResponseDTO buscarChave(final String chavePesquisada) {
        Chave chave = chaveRepository.findByChave(chavePesquisada).orElseThrow(
                () -> new RuntimeException("Chave não encontrada") // Lança uma exceção se a chave não for encontrada
        );

        return ChaveResponseDTO.builder() // Retorna a chave encontrada
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }
}
