package com.retobike.retobackend.controllers;


import com.retobike.retobackend.models.Competencia;
import com.retobike.retobackend.repos.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/competencias")

public class CompetenciaController {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @GetMapping("")
    List<Competencia> index() { return competenciaRepository.findAll(); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Competencia create(@RequestBody Competencia competencia) { return competenciaRepository.save(competencia); }

    @PutMapping("{id}")
    Competencia update(@PathVariable String id, @RequestBody Competencia competencia) {
        Competencia competenciaFrom = competenciaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        competenciaFrom.setNombre(competencia.getNombre());
        competenciaFrom.setFecha(competencia.getFecha());
        competenciaFrom.setLugar(competencia.getLugar());
        competenciaFrom.setDescripcion(competencia.getDescripcion());

        return competenciaRepository.save(competenciaFrom);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Competencia competencia = competenciaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        competenciaRepository.delete(competencia);
    }
}
