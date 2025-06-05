package com.jpa.Repaso1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "No puede estar vacío")
    @Size(min = 10, max = 10, message = "La cédula debe tener 10 dígitos")
    @Column(unique = true)
    private String cedula;

    @NotNull(message = "El precio no puede ser nulo")
    @DecimalMin(value = "10.0", message = "El precio debe ser mayor o igual a 10")
    @DecimalMax(value = "50.0", message = "El precio debe ser menor o igual a 50")
    private Double precio;

    @NotBlank(message = "La dirección no puede estar vacía ni tener espacios")
    @Size(min = 5, max = 100, message = "Debe tener entre 5 y 100 caracteres")
    private String direccion;
}
