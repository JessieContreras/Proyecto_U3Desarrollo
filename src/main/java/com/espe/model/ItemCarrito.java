package com.espe.model;

public class ItemCarrito {
   
    private Plato plato;
    private int cantidad;
    // Constructores, getters y setters

    public ItemCarrito(Plato plato) {
        this.plato = plato;
        this.cantidad = 1;
    }

    public void aumentarCantidad() {
        cantidad++;
    }

    
}
