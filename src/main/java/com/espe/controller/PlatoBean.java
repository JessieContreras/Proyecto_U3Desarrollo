package com.espe.controller;

import com.espe.dao.IPlatoDAO;
import com.espe.idao.PlatoDAOImpl;
import com.espe.model.Categoria;
import com.espe.model.Plato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Named
@ViewScoped
public class PlatoBean implements Serializable { ;

    IPlatoDAO platoDAO = new PlatoDAOImpl();
    //Prueba para pasar datos quemados a la vista
    public List<Plato> obtenerPlatos(){
        return platoDAO.obtenerPlatos();
    }

    public String editar(int id){

        Plato oPlato;
        oPlato = platoDAO.buscar(id);

        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("plato", oPlato);
        System.out.println(oPlato);
        return "./editar.xhtml";
    }

    

    public String eliminar(int id){
        platoDAO.eliminar(id);
        return "/index.xhtml";
    }

    public String nuevo(){
        Part imagenFile;
        Plato oPlato = new Plato();
        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("plato", oPlato);
        return "./crear.xhtml";
    }
                                                public String guardar(Plato plato, Part imagenFile) throws IOException{
        InputStream inputStream = imagenFile.getInputStream();
        byte[] imageBytes = inputStream.readAllBytes();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        System.out.println(base64Image);
        plato.setImagen(base64Image);
        platoDAO.editar(plato);
        return "./index.xhtml";
    }
 public List<Plato> obtenerPlatosPorCategoria(int id){
        return platoDAO.buscarPorCategoria(id);


    }
    public Plato buscar(int id){
        return platoDAO.buscar(id);
    }
}
   
