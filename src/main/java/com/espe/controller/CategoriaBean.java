package com.espe.controller;

import com.espe.dao.ICategoriaDAO;
import com.espe.idao.CategoriaDAOImpl;
import com.espe.model.Categoria;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class CategoriaBean { ;


    ICategoriaDAO categoriaDAO = new CategoriaDAOImpl();
    //Prueba para pasar datos quemados a la vista
    public List<Categoria> obtenerCategorias(){
        return categoriaDAO.obtenerCategorias();
    }

   

    public Categoria obtenerCategoriaPorId(int id){

        Categoria oCategoria;
        return categoriaDAO.buscar(id);
    }

    public String actualizar(Categoria categoria){
        categoriaDAO.editar(categoria);
        return "./index.xhtml";
    }

    public String eliminar(int id){
        categoriaDAO.eliminar(id);
        return "/index.xhtml";
    }
     public String nuevo(){
        Categoria oCategoria = new Categoria();
        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("categoria", oCategoria);
        return "./crear.xhtml";
    }

    public String guardar(Categoria categoria){
        categoriaDAO.guardar(categoria);
        return "./index.xhtml";
    }
}

   
