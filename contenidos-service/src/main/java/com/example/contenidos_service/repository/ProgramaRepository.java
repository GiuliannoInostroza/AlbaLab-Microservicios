package com.example.contenidos_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.contenidos_service.model.Programa;

@Repository
public interface ProgramaRepository extends JpaRepository<Programa, Long> {
}
