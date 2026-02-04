package org.example.repository;

import org.example.model.Personaxe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaxeRepository extends MongoRepository<Personaxe,Long> {
}
