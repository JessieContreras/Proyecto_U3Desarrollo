package com.espe.dao;

import com.espe.model.DetalleFactura;

import java.util.List;

public interface IDetalleFacturaDAO {

    void guardar(DetalleFactura detalleFactura);
    void editar(DetalleFactura detalleFactura);
    DetalleFactura buscar(int id);
    List<DetalleFactura> obtenerDetalleFacturas();
    List<DetalleFactura> obtenerDetalleFacturas(int factura);
    void eliminar(int id);

}
