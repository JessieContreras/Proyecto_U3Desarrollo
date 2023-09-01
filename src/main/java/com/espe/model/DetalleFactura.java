package com.espe.model;
import jakarta.persistence.*;

@Entity
@Table(name = "detalles_factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long factura;

    @Column
    private Long plato;

    private int cantidad;
    private double subtotal;

    public DetalleFactura() {
        super();
    }



    

    // Otros métodos y lógica
}
