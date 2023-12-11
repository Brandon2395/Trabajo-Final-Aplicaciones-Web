/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TrabajoFinal.service;

import com.TrabajoFinal.domain.Contacto;
import jakarta.mail.MessagingException;

/**
 *
 * @author Brandon
 */
public interface CorreoService {
    void enviarCorreo(Contacto correoRequest);
    
    public void enviarCorreoHtml(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}
