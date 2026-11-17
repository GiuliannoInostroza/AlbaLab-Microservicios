package com.example.vinculacion_service.dto;

import java.util.Date;

import com.example.vinculacion_service.model.Solicitud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitudDTO {
    private Long id;
    private String usuarioCorreo;
    private String nombre;
    private String tipo;
    private Integer cantidad;
    private Long fecha;
    private String mensaje;
    private Boolean recurrente;
    private Boolean aceptaContacto;
    private String estado;
    private Date fechaCreacion;

    public Solicitud toModel() {
        return new Solicitud(id, usuarioCorreo, nombre, tipo, cantidad, fecha, mensaje,
                recurrente, aceptaContacto, estado, fechaCreacion);
    }

    public static SolicitudDTO fromModel(Solicitud s) {
        if (s == null) return null;
        return new SolicitudDTO(s.getId(), s.getUsuarioCorreo(), s.getNombre(), s.getTipo(),
                s.getCantidad(), s.getFecha(), s.getMensaje(), s.getRecurrente(),
                s.getAceptaContacto(), s.getEstado(), s.getFechaCreacion());
    }
}
