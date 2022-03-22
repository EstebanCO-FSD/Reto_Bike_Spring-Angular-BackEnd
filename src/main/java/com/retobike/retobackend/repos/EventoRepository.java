package com.retobike.retobackend.repos;

import com.retobike.retobackend.models.Evento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventoRepository extends MongoRepository<Evento, String> {
}
