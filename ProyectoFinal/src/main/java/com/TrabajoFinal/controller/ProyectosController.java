/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TrabajoFinal.controller;

import com.TrabajoFinal.domain.Proyectos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.TrabajoFinal.service.ProyectosService;

@Controller
@Slf4j
@RequestMapping("/proyectos")
public class ProyectosController {
    
    @Autowired
    private ProyectosService proyectosService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var proyectos = proyectosService.getProyectos(false);
        model.addAttribute("proyectos", proyectos);
        model.addAttribute("totalProyectos", proyectos.size());
        return "/proyectos/listado";
    }
    
    @GetMapping("/nuevo")
    public String proyectosNuevo(Proyectos proyectos) {
        return "/proyectos/modifica";
    }

    @PostMapping("/guardar")
    public String proyectosGuardar(Proyectos proyectos) { 
            proyectosService.save(proyectos);
        return "redirect:/proyectos/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String proyectosEliminar(Proyectos proyectos) {
        proyectosService.delete(proyectos);
        return "redirect:/proyectos/listado";
    }

    @GetMapping("/modificar/{id}")
    public String proyectosModificar(Proyectos proyectos, Model model) {
        proyectos = proyectosService.getProyectos(proyectos);
        model.addAttribute("proyectos", proyectos);
        return "/proyectos/modifica";
    }
}
