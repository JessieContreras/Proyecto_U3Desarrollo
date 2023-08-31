package com.espe.controller;

import com.espe.dao.IDetalleFacturaDAO;
import com.espe.idao.DetalleFacturaDAOImpl;
import com.espe.model.DetalleFactura;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class detalleFacturaBean { ;


    IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();
    //Prueba para pasar datos quemados a la vista
    public List<DetalleFactura> obtenerDetalleFacturas(){
        return detalleFacturaDAO.obtenerDetalleFacturas();
    }

    public List<DetalleFactura> obtenerDetalleFacturas(int factura){
        return detalleFacturaDAO.obtenerDetalleFacturas(factura);
    }

    public String editar(int id){

        DetalleFactura oDetalleFactura;
        oDetalleFactura = detalleFacturaDAO.buscar(id);

        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("detalleFactura", oDetalleFactura);
        System.out.println(oDetalleFactura);
        return "./editar.xhtml";
    }

    public DetalleFactura obtenerDetalleFacturaPorId(int id){

        DetalleFactura oDetalleFactura;
        return detalleFacturaDAO.buscar(id);


    }



    public String actualizar(DetalleFactura detalleFactura){
        detalleFacturaDAO.editar(detalleFactura);
        return "./index.xhtml";
    }

    public String eliminar(int id){
        detalleFacturaDAO.eliminar(id);
        return "/index.xhtml";
    }

    public String nuevo(){
        DetalleFactura oDetalleFactura = new DetalleFactura();
        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("detalleFactura", oDetalleFactura);
        return "./crear.xhtml";
    }

    public String guardar(DetalleFactura detalleFactura){
        detalleFacturaDAO.guardar(detalleFactura);
        return "./index.xhtml";
    }
}
