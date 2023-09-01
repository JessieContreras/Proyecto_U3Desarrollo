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
    public List<Plato> obtenerPlatos() {
        List<Plato> listaPlatos;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Plato u");
        listaPlatos = query.getResultList();
        return listaPlatos;
    }
     @Override
    public void eliminar(int id) {
        Plato oPlato;
        oPlato = entityManager.find(Plato.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oPlato);
        entityManager.getTransaction().commit();
    }
