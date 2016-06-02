/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.controllers;

import java.util.Map;
import org.compraventayanuncios.proyecto.entities.Propietario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 
 */
public class PropietarioController {
    
     @RequestMapping(value = "/propietario/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        Propietario owner = new Propietario();
        model.put("propietario", owner);
        return "propietario/createOrUpdateOwnerForm";
    }
    
     @RequestMapping(value = "/propietario/find", method = RequestMethod.GET)
    public String initFindForm(Map<String, Object> model) {
        model.put("propietario", new Propietario());
        return "propietarios/findOwners";
    }
   
}
