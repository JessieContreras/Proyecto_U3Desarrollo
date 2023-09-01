package com.espe.idao;

import com.espe.dao.ICategoriaDAO;
import com.espe.model.Categoria;
import com.espe.model.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class CategoriaDAOImpl implements ICategoriaDAO {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    @Override
    public void guardar(Categoria categoria) {
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        //JPAUtil.shutdown();
    }
    @Override
    public void editar(Categoria categoria) {
        entityManager.getTransaction().begin();
        entityManager.merge(categoria);
        entityManager.getTransaction().commit();
        ///JPAUtil.shutdown();
    }
    @Override
    public Categoria buscar(int id) {
        Categoria oCategoria = new Categoria();
        oCategoria = entityManager.find(Categoria.class, id);
        //JPAUtil.shutdown();
        return oCategoria;
    }
    @Override
    public List<Categoria> obtenerCategorias() {
        List<Categoria> listaCategorias;
        //sentencia JPQL
        Query query = entityManager.createQuery("SELECT u FROM Categoria u");
        listaCategorias = query.getResultList();
        return listaCategorias;
    }
    @Override
    public void eliminar(int id) {
        Categoria oCategoria;
        oCategoria = entityManager.find(Categoria.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(oCategoria);
        entityManager.getTransaction().commit();
    }
}
