package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Afiliacion;
import com.example.accessingdatajpa.repository.AfiliacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliacionService {

    @Autowired
    private AfiliacionRepository afiliacionRepository;

    public List<Afiliacion> getAllAfiliaciones() {
        return afiliacionRepository.findAll();
    }

    public Optional<Afiliacion> getAfiliacionById(Long id) {
        return afiliacionRepository.findById(id);
    }

    public Afiliacion saveAfiliacion(Afiliacion afiliacion) {
        return afiliacionRepository.save(afiliacion);
    }

    public void deleteAfiliacion(Long id) {
        afiliacionRepository.deleteById(id);
    }
}
