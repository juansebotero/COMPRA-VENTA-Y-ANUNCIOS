/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.Dao;

import java.util.Collection;
import org.compraventayanuncios.proyecto.entities.Propietario;
import org.compraventayanuncios.proyecto.entities.Visitas;
import org.springframework.dao.DataAccessException;

/**
 *
 * 
 */
public interface ServicioDao {
    
     Propietario findOwnerById(int id) throws DataAccessException;
     
     void saveVisit(Visitas visitas) throws DataAccessException;
     
     void saveOwner(Propietario owner) throws DataAccessException;
     
     Collection<Propietario> findOwnerByLastName(String lastName) throws DataAccessException;
    
}
