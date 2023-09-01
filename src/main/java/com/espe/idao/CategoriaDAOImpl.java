package com.espe.idao;

import com.espe.dao.ICategoriaDAO;
import com.espe.model.Categoria;
import com.espe.model.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class CategoriaDAOImpl implements ICategoriaDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Categoria categoria) {
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        //JPAUtil.shutdown();
    }


}
