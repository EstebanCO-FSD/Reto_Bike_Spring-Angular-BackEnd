package com.retobike.retobackend.repos;

import com.retobike.retobackend.models.Bicicleta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BicicletaRepository extends MongoRepository<Bicicleta, String> {
}
