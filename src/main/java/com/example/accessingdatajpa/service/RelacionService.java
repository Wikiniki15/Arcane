package com.example.accessingdatajpa.service;

import com.example.accessingdatajpa.entity.Relacion;
import com.example.accessingdatajpa.repository.RelacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
