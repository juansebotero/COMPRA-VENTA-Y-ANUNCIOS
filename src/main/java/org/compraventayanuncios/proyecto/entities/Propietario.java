/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Digits;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

/**
 *
 * 
 */
public class Propietario extends Usuario {
    
    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Ciudad")
    private String ciudad;

    @Column(name = "telefono")
    @Digits(fraction = 0, integer = 10)
    private String telefono;

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    protected Set<Usuario> getUsuInternal() {
        
        return null;
    }

    protected void setUsuInternal(Set<Usuario> usu) {
        
    }

    public List<Usuario> getusu() {
        List<Usuario> sortedPets = new ArrayList<>(getUsuInternal());
        PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedPets);
    }

    public void addUsuario(Usuario usuario) {
        getUsuInternal().add(usuario);
        
    }
    
}
