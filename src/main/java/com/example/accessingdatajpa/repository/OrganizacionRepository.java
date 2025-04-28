package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.entity.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
}
