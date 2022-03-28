package com.retobike.retobackend.controllers;


import com.retobike.retobackend.models.Bicicleta;
import com.retobike.retobackend.repos.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/bicicletas")

public class BicicletaController {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    @GetMapping("")
    List<Bicicleta> index() { return bicicletaRepository.findAll(); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Bicicleta create(@RequestBody Bicicleta bicicleta) { return bicicletaRepository.save(bicicleta); }

    @PutMapping("{id}")
    Bicicleta update(@PathVariable String id, @RequestBody Bicicleta bicicleta) {
        Bicicleta bicicletaFrom = bicicletaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        bicicletaFrom.setMarca(bicicleta.getMarca());
        bicicletaFrom.setTipo(bicicleta.getTipo());
        bicicletaFrom.setColor(bicicleta.getColor());
        bicicletaFrom.setEstado(bicicleta.getEstado());
        bicicletaFrom.setLat(bicicleta.getLat());
        bicicletaFrom.setLon(bicicleta.getLon());

        return bicicletaRepository.save(bicicletaFrom);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Bicicleta bicicleta = bicicletaRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        bicicletaRepository.delete(bicicleta);
    }
}
