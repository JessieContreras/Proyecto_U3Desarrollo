package com.espe.dao;

import com.espe.model.Plato;

import java.util.List;

public interface IPlatoDAO {
     void guardar(Plato plato);
     void editar(Plato plato);
     Plato buscar(int id);
     
}
