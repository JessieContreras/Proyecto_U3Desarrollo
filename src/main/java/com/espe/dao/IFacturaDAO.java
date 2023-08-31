package com.espe.dao;

import com.espe.model.Factura;

import java.util.List;

public interface IFacturaDAO {

    Factura guardar(Factura factura);
    void editar(Factura factura);
    Factura buscar(int id);
    List<Factura> obtenerFacturas();
    void eliminar(int id);
    Factura buscarLogin(String username, String password);
}
