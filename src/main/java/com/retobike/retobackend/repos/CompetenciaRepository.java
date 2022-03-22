package com.retobike.retobackend.repos;


import com.retobike.retobackend.models.Competencia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetenciaRepository extends MongoRepository<Competencia, String> {
}
