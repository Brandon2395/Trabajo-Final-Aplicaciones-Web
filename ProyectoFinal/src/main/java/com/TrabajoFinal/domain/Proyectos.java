/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TrabajoFinal.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Brandon
 */

@Data
@Entity
@Table(name ="proyectos")

//Sereialización va a almacenar datos 
public class Proyectos implements Serializable{
    
    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoría (AUTO_INCREMENT)
    
    @Id /*Id es la llave de la tabla proyecto*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String nombre;
    private String descripcion;
    private int progreso;
    private String comentarios;
    private boolean activo;

    public Proyectos() {
    }

    public Proyectos(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    
}
