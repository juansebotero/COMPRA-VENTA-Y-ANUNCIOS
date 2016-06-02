/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.Dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.compraventayanuncios.proyecto.entities.Propietario;
import org.compraventayanuncios.proyecto.entities.Visitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 
 */
@Service
@Component
public abstract class ServicioDaoImpl implements ServicioDao {
    
    @PersistenceContext
    EntityManager entityManager;
           
    @Transactional
    public void GuardadPropietario(Propietario owner) {
        entityManager.flush();
    }
    @Transactional
    public void BorrarPropietario(Long id){
        entityManager.remove(id);
    }

    @Transactional
    public void GuardarVisit(Visitas visitas) throws DataAccessException {
        entityManager.flush();
    }   
    
    @Transactional
    public void BorrarVisit(Long id){
        entityManager.remove(id);
    }
    
    
}
