package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Relacion;
import com.example.accessingdatajpa.service.RelacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relaciones")
@CrossOrigin(origins = "*")
public class RelacionController {

    @Autowired
    private RelacionService relacionService;

    @GetMapping
    public List<Relacion> getAllRelaciones() {
        return relacionService.getAllRelaciones();
    }

    @GetMapping("/{id}")
    public Optional<Relacion> getRelacionById(@PathVariable Long id) {
        return relacionService.getRelacionById(id);
    }

    @PostMapping
    public Relacion saveRelacion(@RequestBody Relacion relacion) {
        return relacionService.saveRelacion(relacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relacion> actualizarRelacion(@PathVariable Long id, @RequestBody Relacion relacionDetalles) {
        return relacionService.actualizarRelacion(id, relacionDetalles);
    }

    @DeleteMapping("/{id}")
    public void deleteRelacion(@PathVariable Long id) {
        relacionService.deleteRelacion(id);
    }
}
