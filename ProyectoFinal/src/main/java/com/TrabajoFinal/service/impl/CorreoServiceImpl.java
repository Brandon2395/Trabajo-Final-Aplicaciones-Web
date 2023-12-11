package com.TrabajoFinal.service.impl;

import com.TrabajoFinal.domain.Contacto;
import com.TrabajoFinal.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
    
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviarCorreoHtml(
              String para, 
              String asunto, 
              String contenidoHtml) 
              throws MessagingException {
          
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper 
                = new MimeMessageHelper(message, 
                        true);
        helper.setTo(para);
        helper.setSubject(asunto);
        helper.setText(contenidoHtml,true);
        mailSender.send(message);
    }
}
