package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Afiliacion;
import com.example.accessingdatajpa.service.AfiliacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/afiliaciones")
@CrossOrigin(origins = "*")
public class AfiliacionController {

    @Autowired
    private AfiliacionService afiliacionService;

    @GetMapping
    public List<Afiliacion> getAllAfiliaciones() {
        return afiliacionService.getAllAfiliaciones();
    }

    @GetMapping("/{id}")
    public Optional<Afiliacion> getAfiliacionById(@PathVariable Long id) {
        return afiliacionService.getAfiliacionById(id);
    }

    @PostMapping
    public Afiliacion saveAfiliacion(@RequestBody Afiliacion afiliacion) {
        return afiliacionService.saveAfiliacion(afiliacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Afiliacion> actualizarAfiliacion(@PathVariable Long id, @RequestBody Afiliacion afiliacionDetalles) {
        return afiliacionService.actualizarAfiliacion(id, afiliacionDetalles);
    }

    @DeleteMapping("/{id}")
    public void deleteAfiliacion(@PathVariable Long id) {
        afiliacionService.deleteAfiliacion(id);
    }
}
