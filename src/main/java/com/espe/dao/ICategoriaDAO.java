package com.espe.dao;

import com.espe.model.Categoria;
import com.espe.model.Usuario;

import java.util.List;

public interface ICategoriaDAO {
    void guardar(Categoria usuario);
    void editar(Categoria usuario);
    Categoria buscar(int id);
    List<Categoria> obtenerCategorias();
    void eliminar(int id);

}
