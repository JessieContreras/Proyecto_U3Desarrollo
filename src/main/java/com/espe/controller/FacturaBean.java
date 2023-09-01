package com.espe.controller;

import com.espe.dao.IFacturaDAO;
import com.espe.idao.FacturaDAOImpl;
import com.espe.model.Factura;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class FacturaBean {


    IFacturaDAO facturaDAO = new FacturaDAOImpl();
    //Prueba para pasar datos quemados a la vista
    public List<Factura> obtenerFacturas(){
        return facturaDAO.obtenerFacturas();
    }
    public String editar(int id){

        Factura oFactura;
        oFactura = facturaDAO.buscar(id);

        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("factura", oFactura);
        System.out.println(oFactura);
        return "./editar.xhtml";
    }



    public Factura obtenerFacturaPorId(int id){

        Factura oFactura;
        return facturaDAO.buscar(id);


    }



    public String actualizar(Factura factura){
        facturaDAO.editar(factura);
        return "./index.xhtml";
    }

    public String eliminar(int id){
        facturaDAO.eliminar(id);
        return "/index.xhtml";
    }

        public String nuevo(){
        Factura oFactura = new Factura();
        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("factura", oFactura);
        return "./crear.xhtml";
    }


  
