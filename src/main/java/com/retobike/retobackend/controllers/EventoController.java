package com.retobike.retobackend.controllers;

import com.retobike.retobackend.models.Evento;
import com.retobike.retobackend.repos.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/eventos")

public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping("")
    List<Evento> index() {
        return eventoRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Evento create(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @PutMapping("{id}")
    Evento update(@PathVariable String id, @RequestBody Evento evento) {
        Evento eventoFrom = eventoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        eventoFrom.setNombre(evento.getNombre());
        eventoFrom.setFecha(evento.getFecha());
        eventoFrom.setLugar(evento.getLugar());
        eventoFrom.setDescripcion(evento.getDescripcion());

        return eventoRepository.save(eventoFrom);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Evento evento = eventoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        eventoRepository.delete(evento);
    }
}
