package com.espe.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private Long usuario;
    @Column
    private LocalDate fecha;

    @Column
    private double total;
    // Getters y setters


    
}
