/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

/**
 *
 * 
 */

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String Telefono;
    private String Direccion;
    private String Ciudad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
     protected Set<Visitas> getVisitasInternal() {
      
         return null;
    }

    protected void setVisitasInternal(Set<Visitas> visitas) {
        
    }
          
     public List<Visitas> getVisits() {
        List<Visitas> sortedVisits = new ArrayList<>(getVisitasInternal());
        PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedVisits);
    }

    public void addVisit(Visitas visitas) {
        getVisitasInternal().add(visitas);
        visitas.setId(id);
    }

    
}
