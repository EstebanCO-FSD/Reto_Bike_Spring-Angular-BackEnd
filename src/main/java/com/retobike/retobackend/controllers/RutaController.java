package com.retobike.retobackend.controllers;

import com.retobike.retobackend.models.Ruta;
import com.retobike.retobackend.repos.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rutas")

public class RutaController {

    @Autowired
    private RutaRepository rutaRepository;

    @GetMapping("")
    List<Ruta> index() { return rutaRepository.findAll(); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Ruta create(@RequestBody Ruta ruta) { return rutaRepository.save(ruta); }

    @PutMapping("{id}")
    Ruta update(@PathVariable String id, @RequestBody Ruta ruta) {
        Ruta rutaFrom = rutaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        rutaFrom.setNombre(ruta.getNombre());
        rutaFrom.setFecha(ruta.getFecha());
        rutaFrom.setLugar(ruta.getLugar());
        rutaFrom.setDescripcion(ruta.getDescripcion());

        return rutaRepository.save(rutaFrom);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Ruta ruta = rutaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        rutaRepository.delete(ruta);
    }
}
