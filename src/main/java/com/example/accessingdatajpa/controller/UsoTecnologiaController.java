package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.UsoTecnologia;
import com.example.accessingdatajpa.service.UsoTecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usostecnologia")
@CrossOrigin(origins = "*")
public class UsoTecnologiaController {

    @Autowired
    private UsoTecnologiaService usoTecnologiaService;

    @GetMapping
    public List<UsoTecnologia> getAllUsosTecnologia() {
        return usoTecnologiaService.getAllUsosTecnologia();
    }

    @GetMapping("/{id}")
    public Optional<UsoTecnologia> getUsoTecnologiaById(@PathVariable Long id) {
        return usoTecnologiaService.getUsoTecnologiaById(id);
    }

    @PostMapping
    public UsoTecnologia saveUsoTecnologia(@RequestBody UsoTecnologia usoTecnologia) {
        return usoTecnologiaService.saveUsoTecnologia(usoTecnologia);
    }

    @DeleteMapping("/{id}")
    public void deleteUsoTecnologia(@PathVariable Long id) {
        usoTecnologiaService.deleteUsoTecnologia(id);
    }
}
