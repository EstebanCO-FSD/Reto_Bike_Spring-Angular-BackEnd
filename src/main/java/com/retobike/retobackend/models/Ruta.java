package com.retobike.retobackend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class Ruta {

    @Id
    private String id;
    private String nombre;
    private String fecha;
    private String lugar;
    private String descripcion;

}
