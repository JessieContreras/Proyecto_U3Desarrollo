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
     @Override
    public void editar(Plato plato) {
        entityManager.getTransaction().begin();
        entityManager.merge(plato);
        entityManager.getTransaction().commit();
        ///JPAUtil.shutdown();
    }
     @Override
    public Plato buscar(int id) {
        Plato oPlato = new Plato();
        oPlato = entityManager.find(Plato.class, id);
        //JPAUtil.shutdown();
        return oPlato;
    }
     @Override
    public List<Plato> obtenerPlatos() {
        List<Plato> listaPlatos;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Plato u");
        listaPlatos = query.getResultList();
        return listaPlatos;
    }
