package com.espe.controller;

import com.espe.dao.IUsuarioDAO;
import com.espe.idao.UsuarioDAOImpl;
import com.espe.model.Usuario;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestScoped
@Named
public class UsuarioBean { ;
    IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    //Prueba para pasar datos quemados a la vista
    public List<Usuario> obtenerUsuarios(){
        return usuarioDAO.obtenerUsuarios();
    }

    public String editar(int id){

        Usuario oUsuario;
        oUsuario = usuarioDAO.buscar(id);

        //crear una coleccion de tipo map
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("usuario", oUsuario);
        System.out.println(oUsuario);
        return "./editar.xhtml";
    }
    public String actualizar(Usuario usuario){
        usuarioDAO.editar(usuario);
        return "./index.xhtml";
    }
    public String eliminar(int id){
        usuarioDAO.eliminar(id);
        return "/index.xhtml";
    }
    public String nuevo(){
        Usuario oUsuario = new Usuario();
        //crear una coleccion de tipo map
        oUsuario.setRol("admin");
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        //pasar el objeto por medio del SessionMap hacia la vista
        sessionMap.put("usuario", oUsuario);
        return "./crear.xhtml";
    }
     public String guardar(Usuario usuario){
        usuarioDAO.guardar(usuario);
        return "./index.xhtml";
    }
    public String guardarCliente(Usuario usuario){
        usuarioDAO.guardar(usuario);
        return "index.xhtml";
    }
}
