package com.espe.model;

public class ItemCarrito {
   

    // Constructores, getters y setters

    public ItemCarrito(Plato plato) {
        this.plato = plato;
        this.cantidad = 1;
    }

    public void aumentarCantidad() {
        cantidad++;
    }

    public double getTotal() {
        return plato.getPrecio() * cantidad;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
