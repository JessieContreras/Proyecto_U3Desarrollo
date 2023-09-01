package com.espe.idao;

import com.espe.dao.IPlatoDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Plato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class PlatoDAOImpl implements IPlatoDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Plato plato) {
        entityManager.getTransaction().begin();
        entityManager.persist(plato);
        entityManager.getTransaction().commit();
        //JPAUtil.shutdown();
    }
