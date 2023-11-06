/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TrabajoFinal.service;

import com.TrabajoFinal.domain.Proyectos;
import java.util.List;

public interface ProyectosService {
    
    // Se obtiene un listado de categorias en un List
    public List<Proyectos> getProyectos(boolean activos);
    
   // Se obtiene un Proyectos, a partir del id de un categoria
    public Proyectos getProyectos(Proyectos proyecto);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Proyectos proyecto);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Proyectos proyecto);
}
