package org.example.repository;

import org.example.model.LosJojos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JojosRepository extends MongoRepository<LosJojos, String> {
}
