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
    @Override
    public void eliminar(int id) {
        Factura oFactura;
        oFactura = entityManager.find(Factura.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oFactura);
        entityManager.getTransaction().commit();
    }
  
    @Override
    public Factura   buscarLogin(String username, String contrasena){
        Factura factura;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Factura u where u.correo=:correo and u.contrasena=:contrasena");
        query.setParameter("correo",username);
        query.setParameter("contrasena",contrasena);
        factura = (Factura) query.getSingleResult();
        return factura;
    }
}
