/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * 
 */
@MappedSuperclass
public class NamedEntity extends BaseEntity {
    
     @Column(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
}
