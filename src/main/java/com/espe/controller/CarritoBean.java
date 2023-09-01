package com.espe.controller;


import com.espe.dao.IDetalleFacturaDAO;
import com.espe.dao.IFacturaDAO;
import com.espe.dao.IPlatoDAO;
import com.espe.idao.DetalleFacturaDAOImpl;
import com.espe.idao.FacturaDAOImpl;
import com.espe.idao.PlatoDAOImpl;
import com.espe.model.*;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
@Named
public class CarritoBean implements Serializable {
    private List<ItemCarrito> carrito = new ArrayList<>();

    public List<ItemCarrito> getCarrito() {
        return carrito;
    }
    IFacturaDAO facturaDAO = new FacturaDAOImpl();
    IDetalleFacturaDAO detalleFacturaDAO = new DetalleFacturaDAOImpl();

    DecimalFormat df = new DecimalFormat("#.00");
    public void agregarProducto(Plato plato) {
        // Busca si el producto ya está en el carrito
        ItemCarrito itemExistente = carrito.stream()
                .filter(item -> item.getPlato().equals(plato))
                .findFirst()
                .orElse(null);

        if (itemExistente != null) {
            // Si el producto ya está en el carrito, aumenta la cantidad
            itemExistente.aumentarCantidad();
        } else {
            // Si el producto no está en el carrito, agrega uno nuevo
            carrito.add(new ItemCarrito(plato));
        }
    }

    public void eliminarProducto(Plato producto) {
        carrito.removeIf(item -> item.getPlato().equals(producto));
    }
    public double subtotal() {
        double subtotal = 0.0;
        for(ItemCarrito pro :carrito) {
            subtotal += pro.getPlato().getPrecio() * pro.getCantidad();
        }
        return subtotal;
    }

    public String subtotalString() {

        return df.format(subtotal());
    }
    
   

    public String faturar() {
        Factura factura = new Factura();
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

        LocalDate lt = LocalDate.now();
        Usuario user = (Usuario) sessionMap.get("session");
        factura.setFecha(lt);
        factura.setTotal(subtotal());
        factura.setUsuario(user.getId());
      Factura fac =   facturaDAO.guardar(factura);
        
        for (ItemCarrito car:carrito ) {
            DetalleFactura df = new DetalleFactura();
            df.setCantidad(car.getCantidad());
            df.setFactura(fac.getId());
            df.setPlato(car.getPlato().getId());
            df.setSubtotal(car.getPlato().getId()*car.getCantidad());

            detalleFacturaDAO.guardar(df);
        }

        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("factura", factura);
        carrito =  new ArrayList<>();
        return "factura.xhtml";
    }
    public String procederPago(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        
        if(externalContext.getSessionMap().get("session")!=null){
            return "carrito.xhtml";
            
        }else{
            Usuario oUsuario = new Usuario();
            //crear una coleccion de tipo map
            oUsuario.setRol("cliente");
            Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            //pasar el objeto por medio del SessionMap hacia la vista
            sessionMap.put("usuario", oUsuario);
            return "registerClient.xhtml";
        }

    }
}

