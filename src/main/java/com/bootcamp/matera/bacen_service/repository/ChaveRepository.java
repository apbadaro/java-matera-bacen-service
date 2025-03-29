package com.bootcamp.matera.bacen_service.repository;

import com.bootcamp.matera.bacen_service.model.Chave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

// classe repository para persistir os dados no banco de dados

@Repository
public interface ChaveRepository extends JpaRepository<Chave, UUID> {

    // métodos para manipular os dados no banco de dados
    // Em vez de usa queries SQL, usamos métodos que o Spring Data JPA já implementa

    // os parametros do metodo são declarados como final para evitar que sejam alterados
    // o nome do metodo é o mesmo que o nome da coluna no banco de dados
    // final é uma espécie de variável constante (comparando ao JS)

    boolean existsByChave(final String chave); // verifica se a chave existe no banco de dados

    Optional<Chave> findByChave(final String chavePesquisada); // busca a chave no banco de dados
}
