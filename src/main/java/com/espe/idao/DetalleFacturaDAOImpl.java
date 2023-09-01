package com.espe.idao;

import com.espe.dao.IDetalleFacturaDAO;
import com.espe.model.DetalleFactura;
import com.espe.model.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class DetalleFacturaDAOImpl implements IDetalleFacturaDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(DetalleFactura detalleDetalleFactura) {
        entityManager.getTransaction().begin();
        entityManager.persist(detalleDetalleFactura);
        entityManager.getTransaction().commit();
        //JPAUtil.shutdown();
    }
    @Override
    public void editar(DetalleFactura detalleDetalleFactura) {
        entityManager.getTransaction().begin();
        entityManager.merge(detalleDetalleFactura);
        entityManager.getTransaction().commit();
        ///JPAUtil.shutdown();
    }

 
