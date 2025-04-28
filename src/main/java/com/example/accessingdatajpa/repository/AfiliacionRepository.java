package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.entity.Afiliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionRepository extends JpaRepository<Afiliacion, Long> {
}
