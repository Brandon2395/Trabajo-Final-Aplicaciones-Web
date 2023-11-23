package com.TrabajoFinal.service.impl;

import com.TrabajoFinal.domain.Contacto;
import com.TrabajoFinal.service.CorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void enviarCorreo(Contacto correoRequest) {
        // Crear un objeto SimpleMailMessage
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("parallaxsourcecontacto@gmail.com"); // Reemplazar con el destino del correo electrónico
        message.setSubject(correoRequest.getNombre() + " ha enviado un mensaje");
        message.setText(
                "Nombre: " + correoRequest.getNombre() + "\n" +
                        "Apellidos: " + correoRequest.getApellidos() + "\n" +
                        "Email: " + correoRequest.getEmail() + "\n" +
                        "Teléfono: " + correoRequest.getTelefono() + "\n" +
                        "Mensaje: " + correoRequest.getMensaje());

        // Enviar el correo electrónico
        javaMailSender.send(message);
    }
}
