package org.example.repository;

import org.example.model.Saga;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SagaRepository extends MongoRepository<Saga, Long> {
    Optional<List<Saga>> findByTitulo(String nombre);
}
