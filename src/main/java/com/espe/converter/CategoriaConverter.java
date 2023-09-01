package com.espe.converter;

import com.espe.controller.CategoriaBean;
import com.espe.dao.ICategoriaDAO;
import com.espe.idao.CategoriaDAOImpl;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

import com.espe.model.Categoria;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.logging.Logger;
@FacesConverter(value = "categoriaConverter")
@Named
@RequestScoped
public class CategoriaConverter implements Converter<Categoria> {

    @Inject
    private CategoriaBean categoriaBean;

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            int id = Integer.parseInt(value);
            return categoriaBean.obtenerCategoriaPorId(id);
        }
        return null;
    }

    
    @Override
    public String getAsString(FacesContext context, UIComponent component, Categoria categoria) {
        if (categoria != null) {
            return String.valueOf(categoria.getId());
        }
        return null;
    }
}
