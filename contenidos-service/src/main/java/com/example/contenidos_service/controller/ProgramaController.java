package com.example.contenidos_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contenidos_service.dto.ProgramaDTO;
import com.example.contenidos_service.model.Programa;
import com.example.contenidos_service.service.ProgramaService;

@RestController
@RequestMapping("/programas")
public class ProgramaController {

	private final ProgramaService programaService;

	public ProgramaController(ProgramaService programaService) {
		this.programaService = programaService;
	}

	@PostMapping
	public ResponseEntity<ProgramaDTO> crearPrograma(@RequestBody ProgramaDTO programaDto) {
		Programa nuevo = programaService.guardar(programaDto.toModel());
		return ResponseEntity.ok(ProgramaDTO.fromModel(nuevo));
	}

	@GetMapping
	public ResponseEntity<List<ProgramaDTO>> listarProgramas() {
		List<Programa> programas = programaService.listar();
		List<ProgramaDTO> dtos = programas.stream().map(ProgramaDTO::fromModel).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}
}
