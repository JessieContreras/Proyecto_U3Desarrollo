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
    @Override
    public DetalleFactura buscar(int id) {
        DetalleFactura oDetalleFactura = new DetalleFactura();
        oDetalleFactura = entityManager.find(DetalleFactura.class, id);
        //JPAUtil.shutdown();
        return oDetalleFactura;
    }
     @Override
    public List<DetalleFactura> obtenerDetalleFacturas() {
        List<DetalleFactura> listaDetalleFacturas;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM DetalleFactura u");
        listaDetalleFacturas = query.getResultList();
        return listaDetalleFacturas;
    }
     @Override
    public void eliminar(int id) {
        DetalleFactura oDetalleFactura;
        oDetalleFactura = entityManager.find(DetalleFactura.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oDetalleFactura);
        entityManager.getTransaction().commit();
    }
     @Override
    public List<DetalleFactura> obtenerDetalleFacturas(int factura) {
        List<DetalleFactura> listaDetalleFacturas;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM DetalleFactura u where u.factura=:factura");
        query.setParameter("factura",factura);
        listaDetalleFacturas = query.getResultList();
        return listaDetalleFacturas;
    }

}

 
