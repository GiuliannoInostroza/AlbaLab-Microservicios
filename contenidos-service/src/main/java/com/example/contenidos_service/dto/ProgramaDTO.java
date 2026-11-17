package com.example.contenidos_service.dto;

import com.example.contenidos_service.model.Programa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProgramaDTO {
    private Long id;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String destinoAporte;
    private String tipoColaboracion;

    public Programa toModel() {
        return new Programa(id, nombre, categoria, descripcion, destinoAporte, tipoColaboracion);
    }

    public static ProgramaDTO fromModel(Programa p) {
        if (p == null) return null;
        return new ProgramaDTO(p.getId(), p.getNombre(), p.getCategoria(), p.getDescripcion(),
                p.getDestinoAporte(), p.getTipoColaboracion());
    }
}
