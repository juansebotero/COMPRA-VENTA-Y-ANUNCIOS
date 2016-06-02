/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.compraventayanuncios.proyecto.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.compraventayanuncios.proyecto.Dao.UsuarioDao;
import org.compraventayanuncios.proyecto.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 
 */

public class LoginController {
    @Autowired
    UsuarioDao usuarioDao;
 
    @RequestMapping (value= "/login", method = RequestMethod.GET)
    public String login(ModelMap model){
        return "login";
    }
    
    @RequestMapping (value= "/login", method = RequestMethod.POST)
    public String autenticar(@ModelAttribute("email") String email, @ModelAttribute("password") String password,HttpServletRequest request, ModelMap model){
        model.clear();
        Usuario usuario = usuarioDao.buscarPorEmail(email);
        if(usuario != null && password.equals(usuario.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("autenticado",true);
            session.setAttribute("usuarioId", usuario.getId());
            return "redirect/";
        }else{
            model.addAttribute("error","Email o Password incorrecto");
            return "redirect/login";
        }
    }
        
    @RequestMapping (value= "/logout", method = RequestMethod.GET)
    public String salir(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("autenticado");
        session.removeAttribute("usuarioId");
        session.invalidate();
        return "redirect:/login";
        
    }
    
}
