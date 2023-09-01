package com.espe.idao;

import com.espe.dao.IUsuarioDAO;
import com.espe.model.JPAUtil;
import com.espe.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UsuarioDAOImpl implements IUsuarioDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        //JPAUtil.shutdown();
    }
     @Override
    public void editar(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        ///JPAUtil.shutdown();
    }

   
