package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Relacion;
import com.example.accessingdatajpa.repository.RelacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelacionService {

    @Autowired
    private RelacionRepository relacionRepository;

    public List<Relacion> getAllRelaciones() {
        return relacionRepository.findAll();
    }

    public Optional<Relacion> getRelacionById(Long id) {
        return relacionRepository.findById(id);
    }

    public Relacion saveRelacion(Relacion relacion) {
        return relacionRepository.save(relacion);
    }

    public void deleteRelacion(Long id) {
        relacionRepository.deleteById(id);
    }

    public ResponseEntity<Relacion> actualizarRelacion(Long id, Relacion relacionDetalles) {
        Optional<Relacion> relacionOptional = relacionRepository.findById(id);
        if (relacionOptional.isPresent()) {
            Relacion relacionExistente = relacionOptional.get();
            relacionExistente.setId_personaje_a(relacionDetalles.getId_personaje_a());
            relacionExistente.setId_personaje_b(relacionDetalles.getId_personaje_b());
            relacionExistente.setTipo_relacion(relacionDetalles.getTipo_relacion());
            relacionRepository.save(relacionExistente);
            return ResponseEntity.ok(relacionExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
