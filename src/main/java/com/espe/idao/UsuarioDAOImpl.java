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

     @Override
    public Usuario buscar(int id) {
        Usuario oUsuario = new Usuario();
        oUsuario = entityManager.find(Usuario.class, id);
        //JPAUtil.shutdown();
        return oUsuario;
    }
    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> listaUsuarios;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Usuario u");
        listaUsuarios = query.getResultList();
        return listaUsuarios;
    }

    @Override
    public void eliminar(int id) {
        Usuario oUsuario;
        oUsuario = entityManager.find(Usuario.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oUsuario);
        entityManager.getTransaction().commit();
    }
     @Override
    public Usuario   buscarLogin(String username, String contrasena){
        Usuario usuario;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Usuario u where u.correo=:correo and u.contrasena=:contrasena");
        query.setParameter("correo",username);
        query.setParameter("contrasena",contrasena);
        usuario = (Usuario) query.getSingleResult();
        return usuario;
    }
}

   
