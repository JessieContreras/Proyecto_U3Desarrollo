package com.espe.dao;

import com.espe.model.Usuario;

import java.util.List;

public interface IUsuarioDAO {

    void guardar(Usuario usuario);
    void editar(Usuario usuario);
    Usuario buscar(int id);
    List<Usuario> obtenerUsuarios();
    void eliminar(int id);
    Usuario buscarLogin(String username, String password);
}
