package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Tecnologia;
import com.example.accessingdatajpa.service.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tecnologias")
@CrossOrigin(origins = "*")
public class TecnologiaController {

    @Autowired
    private TecnologiaService tecnologiaService;

    @GetMapping
    public List<Tecnologia> getAllTecnologias() {
        return tecnologiaService.getAllTecnologias();
    }

    @GetMapping("/{id}")
    public Optional<Tecnologia> getTecnologiaById(@PathVariable Long id) {
        return tecnologiaService.getTecnologiaById(id);
    }

    @PostMapping
    public Tecnologia saveTecnologia(@RequestBody Tecnologia tecnologia) {
        return tecnologiaService.saveTecnologia(tecnologia);
    }

    @DeleteMapping("/{id}")
    public void deleteTecnologia(@PathVariable Long id) {
        tecnologiaService.deleteTecnologia(id);
    }
}
