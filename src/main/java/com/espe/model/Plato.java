package com.espe.model;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "platos")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private double precio;

    @Column
    private Long categoria;

    @Column(name = "imagen",  columnDefinition = "LONGTEXT")
    private String imagen;
    // Getters y setters


   
}
