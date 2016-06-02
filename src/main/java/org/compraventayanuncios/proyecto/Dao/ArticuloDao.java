/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.compraventayanuncios.proyecto.entities.Articulo;
import org.springframework.stereotype.Component;



/**
 *
 * 
 */
@Component
public class ArticuloDao {
 
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Articulo articulo) {
        entityManager.persist(articulo);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Articulo articulo) {
        entityManager.merge(articulo);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
        Articulo articulo = entityManager.find(Articulo.class, id);
        entityManager.remove(articulo);
        entityManager.flush();
    }
    
    @Transactional
    public Articulo obtener(Long id) {
        Articulo articulo = entityManager.find(Articulo.class, id);
        return articulo;
    }

    @Transactional
    public List<Articulo> listar() {
        List<Articulo> articulos = entityManager.createQuery("SELECT a FROM Articulo a").getResultList();
        return articulos;
    }

    
}
