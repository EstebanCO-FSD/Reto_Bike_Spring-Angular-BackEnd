package com.retobike.retobackend.repos;

import com.retobike.retobackend.models.Ruta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RutaRepository extends MongoRepository<Ruta, String> {
}
