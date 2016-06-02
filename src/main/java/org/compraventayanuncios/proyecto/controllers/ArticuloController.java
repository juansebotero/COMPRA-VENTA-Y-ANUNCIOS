/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.compraventayanuncios.proyecto.Dao.ArticuloDao;
import org.compraventayanuncios.proyecto.Dao.CategoriaDao;
import org.compraventayanuncios.proyecto.entities.Articulo;
import org.compraventayanuncios.proyecto.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



/**
 *
 * 
 */
@Controller
public class ArticuloController {
    
    @Autowired
    ArticuloDao articuloDao;
    
    @Autowired
    CategoriaDao categoriaDao;
    
    @RequestMapping(value = "/articulos/listado", method = RequestMethod.GET)
    public String listado(){
        return "articulos/listado";
    }
    
    @RequestMapping(path = "/api/articulos", method = RequestMethod.POST)
    @ResponseBody
    public void guardar(@ModelAttribute Articulo articulo, @ModelAttribute("categoria_id") Long categoriaId) {
        Categoria categoria = categoriaDao.obtener(categoriaId);
        articulo.setCategoria(categoria);
        articuloDao.agregar(articulo);
    }
    
    @RequestMapping(path = "/api/articulos/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void editar(@PathVariable Long id, @ModelAttribute Articulo articulo, @ModelAttribute("categoria_id") Long categoriaId) {
        Categoria categoria = categoriaDao.obtener(categoriaId);
        articulo.setCategoria(categoria);
        articulo.setId(id);
        articuloDao.editar(articulo);
    }
    
    @RequestMapping(path = "/api/articulos/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void borrar(@PathVariable Long id) {
        articuloDao.borrar(id);
    }
    
    @RequestMapping(path = "/api/articulos", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Articulo> listar() {
        return articuloDao.listar();
    }
    
    @RequestMapping(path = "/api/articulos/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Articulo obtener(@PathVariable("id") Long id) {
        return articuloDao.obtener(id);
    }
    
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "La carga esta completa " + name + "!";
            } catch (Exception e) {
                return "La carga acaba de fallar " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }


    
}
