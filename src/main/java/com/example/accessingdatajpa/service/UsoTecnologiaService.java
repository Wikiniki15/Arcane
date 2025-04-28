package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.UsoTecnologia;
import com.example.accessingdatajpa.repository.UsoTecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsoTecnologiaService {

    @Autowired
    private UsoTecnologiaRepository usoTecnologiaRepository;

    public List<UsoTecnologia> getAllUsosTecnologia() {
        return usoTecnologiaRepository.findAll();
    }

    public Optional<UsoTecnologia> getUsoTecnologiaById(Long id) {
        return usoTecnologiaRepository.findById(id);
    }

    public UsoTecnologia saveUsoTecnologia(UsoTecnologia uso) {
        return usoTecnologiaRepository.save(uso);
    }

    public void deleteUsoTecnologia(Long id) {
        usoTecnologiaRepository.deleteById(id);
    }

    public ResponseEntity<UsoTecnologia> actualizarUsoTecnologia(Long id, UsoTecnologia usoDetalles) {
        Optional<UsoTecnologia> usoOptional = usoTecnologiaRepository.findById(id);
        if (usoOptional.isPresent()) {
            UsoTecnologia usoExistente = usoOptional.get();
            usoExistente.setId_personaje(usoDetalles.getId_personaje());
            usoExistente.setId_tecnologia(usoDetalles.getId_tecnologia());
            usoTecnologiaRepository.save(usoExistente);
            return ResponseEntity.ok(usoExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
