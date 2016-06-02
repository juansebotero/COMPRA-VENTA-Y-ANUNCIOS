/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.controllers;

import java.util.List;
import org.compraventayanuncios.proyecto.Dao.CategoriaDao;
import org.compraventayanuncios.proyecto.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * 
 */
@Controller
public class CategoriasController {
     
    @Autowired
    CategoriaDao categoriaDao;
    
    @RequestMapping(value = "/categorias/listado", method = RequestMethod.GET)
    public String listado(){
        return "categorias/listado";
    }
    
    @RequestMapping(path = "/api/categorias", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Categoria categoria) {
        categoriaDao.agregar(categoria);
    }
    
    @RequestMapping(path = "/api/categorias/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Categoria categoria) {
        categoria.setId(id);
        categoriaDao.editar(categoria);
    }
    
    @RequestMapping(path = "/api/categorias/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        categoriaDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/categorias", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Categoria> listar() {
        return categoriaDao.listar();
    }
    
    @RequestMapping(path = "/api/categorias/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Categoria obtener(@PathVariable("id") Long id) {
        return categoriaDao.obtener(id);
    }   
}
