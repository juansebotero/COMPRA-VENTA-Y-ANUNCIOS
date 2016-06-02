/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.controllers;

import java.util.Map;
import javax.validation.Valid;
import org.compraventayanuncios.proyecto.entities.Usuario;
import org.compraventayanuncios.proyecto.entities.Visitas;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 
 */
public class VisitasController {
    
    
    @ModelAttribute("visit")
    public Visitas loadPetWithVisit(@PathVariable("UsuarioId") int Id) {
        Visitas visitas = new Visitas();
        return visitas;
    }
    
    @RequestMapping(value = "/owners/*/usuario/{UsuarioId}/visits/new", method = RequestMethod.GET)
    public String initNewVisitForm(@PathVariable("UsuarioId") int petId, Map<String, Object> model) {
        return "Usuario/createOrUpdateVisitForm";
    }
}
