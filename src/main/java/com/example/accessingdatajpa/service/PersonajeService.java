package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Personaje;
import com.example.accessingdatajpa.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> getAllPersonajes() {
        return personajeRepository.findAll();
    }

    public Optional<Personaje> getPersonajeById(Long id) {
        return personajeRepository.findById(id);
    }

    public Personaje savePersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }

    public ResponseEntity<Personaje> actualizarPersonaje(Long id, Personaje personajeDetalles) {
        Optional<Personaje> personajeOptional = personajeRepository.findById(id);
        if (personajeOptional.isPresent()) {
            Personaje personajeExistente = personajeOptional.get();
            personajeExistente.setNombre(personajeDetalles.getNombre());
            personajeExistente.setOrigen(personajeDetalles.getOrigen());
            personajeExistente.setRol(personajeDetalles.getRol());
            personajeExistente.setAlineacion(personajeDetalles.getAlineacion());
            personajeRepository.save(personajeExistente);
            return ResponseEntity.ok(personajeExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
