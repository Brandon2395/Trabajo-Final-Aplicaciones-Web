/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TrabajoFinal.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Brandon
 */
public interface ReporteService {
   
    public ResponseEntity<Resource>
            generarReporte(
            String reporte, //El nombre del archivo llamado .jasper
                    Map<String,Object> parametros, //Los parametros del reporte
                    String tipo) throws IOException; //El tipo de reporte que se va a mostrar (csv, pdf, excel, txt)         
}
