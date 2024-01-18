package com.djl.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length=100, nullable = false)
    private String nombre;
    @Column(length=255, nullable = false, unique = true)
    private String correo;
    @Temporal(TemporalType.DATE) @Column(nullable=false)
    private Date fechaNacimiento;
    @Column(length=9, nullable = false)
    private String Celular;
}
