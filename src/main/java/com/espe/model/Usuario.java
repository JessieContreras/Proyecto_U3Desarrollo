package com.espe.model;

import jakarta.persistence.*;
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String correo;
    // Agregamos el campo para el rol
     @Column
    private String rol;
    
    @Column
    private String contrasena; // Agregamos el campo para la contraseña
    // Getters y setters

    @Column
    private String telefono; // Agregamos el campo para el telefono
    // Getters y setters

    @Column
    private String direccion; // Agregamos el campo para la direccion
    // Getters y setters

    
}
