package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Organizacion;
import com.example.accessingdatajpa.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/organizaciones")
@CrossOrigin(origins = "*")
public class OrganizacionController {

    @Autowired
    private OrganizacionService organizacionService;

    @GetMapping
    public List<Organizacion> getAllOrganizaciones() {
        return organizacionService.getAllOrganizaciones();
    }

    @GetMapping("/{id}")
    public Optional<Organizacion> getOrganizacionById(@PathVariable Long id) {
        return organizacionService.getOrganizacionById(id);
    }

    @PostMapping
    public Organizacion saveOrganizacion(@RequestBody Organizacion organizacion) {
        return organizacionService.saveOrganizacion(organizacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizacion> actualizarOrganizacion(@PathVariable Long id, @RequestBody Organizacion organizacionDetalles) {
        return organizacionService.actualizarOrganizacion(id, organizacionDetalles);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizacion(@PathVariable Long id) {
        organizacionService.deleteOrganizacion(id);
    }
}
