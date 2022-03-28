package com.retobike.retobackend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document

public class Bicicleta {

    @Id
    private String id;
    private String marca;
    private String tipo;
    private String color;
    private Boolean estado;
    private Number lat;
    private Number lon;

}
