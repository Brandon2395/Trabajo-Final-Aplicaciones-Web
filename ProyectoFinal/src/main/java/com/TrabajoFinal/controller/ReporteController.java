package com.TrabajoFinal.controller;
import com.TrabajoFinal.service.ReporteService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller 
@RequestMapping("/reportes")
public class ReporteController {
   @Autowired
   ReporteService reporteService; 
   @GetMapping("/plantillareportes") //Mostrar solo el html 
   public String principal(Model model){ 
       return "/reportes/plantillareportes"; 
   }
   @GetMapping("/usuarios")
   public ResponseEntity<Resource> usuarios(@RequestParam String tipo)throws IOException{ 
       return reporteService.generarReporte("usuarios", null, tipo);
   }
   
   @GetMapping("/proyectos")
   public ResponseEntity<Resource> ventas(@RequestParam String tipo)throws IOException{ 
       return reporteService.generarReporte("proyectos", null, tipo);
   }

}