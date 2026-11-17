package com.example.contenidos_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.contenidos_service.model.Programa;
import com.example.contenidos_service.repository.ProgramaRepository;

@Service
public class ProgramaService {

	private final ProgramaRepository programaRepository;

	public ProgramaService(ProgramaRepository programaRepository) {
		this.programaRepository = programaRepository;
	}

	public Programa guardar(Programa programa) {
		return programaRepository.save(programa);
	}

	public List<Programa> listar() {
		return programaRepository.findAll();
	}
}
