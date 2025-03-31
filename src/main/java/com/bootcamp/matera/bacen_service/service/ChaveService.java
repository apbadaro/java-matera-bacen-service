package com.bootcamp.matera.bacen_service.service;

import com.bootcamp.matera.bacen_service.dto.ChaveRequestDTO;
import com.bootcamp.matera.bacen_service.dto.ChaveResponseDTO;
import com.bootcamp.matera.bacen_service.exception.ChaveJaCadastradaException;
import com.bootcamp.matera.bacen_service.exception.ChaveNaoLocalizadaException;
import com.bootcamp.matera.bacen_service.model.Chave;
import com.bootcamp.matera.bacen_service.repository.ChaveRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// classe service para manipular os dados do banco de dados

@RequiredArgsConstructor // Lombok cria um construtor automaticamente para fazer a injeção da dependência ChaveRepository
@Component // Anotação que indica que essa classe é um componente (Bean) gerenciado pelo Spring
public class ChaveService {

    private final ChaveRepository chaveRepository; // Injeção de dependência automática feita pelo Lombok

    /*
    * Metodo para criar uma nova chave
    *
    * @param chaveRequestDTO - Objeto que contém os dados da chave a ser criada
    * @return ChaveResponseDTO - Objeto que contém os dados da chave criada
    * @throws ChaveJaCadastradaException - Exceção lançada quando a chave já está cadastrada
    * @throws ChaveNaoLocalizadaException - Exceção lançada quando a chave não é encontrada
    * @throws Exception - Exceção lançada quando ocorre algum erro inesperado
    *
    * anotação @Transactional serve para garantir a integridade dos dados,
    * em caso de falha, a transação é revertida graças ao @Transactional
    */
    @Transactional
    public ChaveResponseDTO criarChave(final ChaveRequestDTO chaveRequestDTO) {

        if (chaveRepository.existsByChave(chaveRequestDTO.getChave())) {
            throw new ChaveJaCadastradaException(
                    String.format("A chave '%s' já está cadastrada", chaveRequestDTO.getChave()) // Lança uma exceção se a chave já estiver cadastrada
            );
        }

        Chave chave = Chave.builder() // Cria um novo objeto Chave
                .chave(chaveRequestDTO.getChave())
                .ativa(chaveRequestDTO.getAtiva())
                .build();

        chave = chaveRepository.save(chave); // Salva a chave criada no banco de dados

//        Simulando uma exceção para testar o rollback da persistência da chave no BD (graças ao @Transactional)
//        int a = 0 / 0;

        // Retorna a chave criada
        return ChaveResponseDTO.builder()
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }

    // Metodo para buscar uma chave pelo ID
    public ChaveResponseDTO buscarChave(final String chavePesquisada) {
        Chave chave = chaveRepository.findByChave(chavePesquisada).orElseThrow(
                () -> new ChaveNaoLocalizadaException(
                        String.format("A chave '%s' não foi encontrada", chavePesquisada) // Lança uma exceção se a chave não for encontrada
                )
        );

        return ChaveResponseDTO.builder() // Retorna a chave encontrada
                .chave(chave.getChave())
                .ativa(chave.getAtiva())
                .build();
    }
}