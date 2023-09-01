package com.espe.controller;


import com.espe.dao.IUsuarioDAO;
import com.espe.idao.UsuarioDAOImpl;
import com.espe.model.Usuario;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.SecurityContext;


import java.io.IOException;
import java.util.HashSet;


@ManagedBean
@RequestScoped
@Named
public class LoginBean {
    IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
     public String getStoredRole() {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            return (String) externalContext.getSessionMap().get("rol");
        }
     public void logout(){
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("session");
    
            try {
                // Redirigir a la página deseada
                externalContext.redirect(externalContext.getRequestContextPath() + "/index.xhtml");
                
            } catch (IOException e) {
                // Manejo de errores de redirección
            }
        }
 }
