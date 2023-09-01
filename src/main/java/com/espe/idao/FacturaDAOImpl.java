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
     @Override
        public void editar(Factura factura) {
            entityManager.getTransaction().begin();
            entityManager.merge(factura);
            entityManager.getTransaction().commit();
            ///JPAUtil.shutdown();
        }
     @Override
    public Factura buscar(int id) {
        Factura oFactura = new Factura();
        oFactura = entityManager.find(Factura.class, id);
        //JPAUtil.shutdown();
        return oFactura;
    }
    @Override
    public List<Factura> obtenerFacturas() {
        List<Factura> listaFacturas;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Factura u");
        listaFacturas = query.getResultList();
        return listaFacturas;
    }
  
