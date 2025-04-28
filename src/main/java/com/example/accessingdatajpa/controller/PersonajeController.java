package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.entity.Personaje;
import com.example.accessingdatajpa.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personajes")
@CrossOrigin(origins = "*")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personaje> getAllPersonajes() {
        return personajeService.getAllPersonajes();
    }

    @GetMapping("/{id}")
    public Optional<Personaje> getPersonajeById(@PathVariable Long id) {
        return personajeService.getPersonajeById(id);
    }

    @PostMapping
    public Personaje savePersonaje(@RequestBody Personaje personaje) {
        return personajeService.savePersonaje(personaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> actualizarPersonaje(@PathVariable Long id, @RequestBody Personaje personajeDetalles) {
        return personajeService.actualizarPersonaje(id, personajeDetalles);
    }

    @DeleteMapping("/{id}")
    public void deletePersonaje(@PathVariable Long id) {
        personajeService.deletePersonaje(id);
    }
}
