package com.espe.idao;

import com.espe.dao.IFacturaDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Factura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class FacturaDAOImpl implements IFacturaDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public Factura guardar(Factura factura) {

        entityManager.getTransaction().begin();
        entityManager.persist(factura);
        entityManager.getTransaction().commit();
        entityManager.refresh(factura);
        return  factura;
        //JPAUtil.shutdown();
    }

  
