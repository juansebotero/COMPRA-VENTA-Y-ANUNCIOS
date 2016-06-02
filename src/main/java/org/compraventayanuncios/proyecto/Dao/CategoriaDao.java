/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.compraventayanuncios.proyecto.entities.Categoria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @
 */
@Component
public class CategoriaDao {
    
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void agregar(Categoria categoria) {
        entityManager.persist(categoria);
        entityManager.flush();
    }
    
    @Transactional
    public void editar(Categoria categoria) {
        entityManager.merge(categoria);
        entityManager.flush();
    }
    
    @Transactional
    public void borrar(Long id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        entityManager.remove(categoria);
        entityManager.flush();
    }
    
    @Transactional
    public Categoria obtener(Long id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        return categoria;
    }

    @Transactional
    public List<Categoria> listar() {
        List<Categoria> categorias = entityManager.createQuery("SELECT c FROM Categoria c").getResultList();
        return categorias;
    }
}
