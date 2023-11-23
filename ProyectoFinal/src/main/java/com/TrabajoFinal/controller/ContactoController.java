/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TrabajoFinal.controller;


import com.TrabajoFinal.domain.Contacto;
import com.TrabajoFinal.service.CorreoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/contacto")
public class ContactoController {

    @GetMapping("listado")
    public String getContacto() {
        return "/contacto/listado";
    }

    @Autowired
    private CorreoService correoService;

   @PostMapping(value = "/enviar-correo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String enviarCorreo(@RequestParam("nombre") String nombre,
                               @RequestParam("apellidos") String apellidos,
                               @RequestParam("email") String email,
                               @RequestParam("telefono") int telefono,
                               @RequestParam("mensaje") String mensaje,
                               @RequestPart(value = "archivo", required = false) MultipartFile archivo) {
        // Crear un objeto Contacto con los datos del formulario
        Contacto correoRequest = new Contacto();
        correoRequest.setNombre(nombre);
        correoRequest.setApellidos(apellidos);
        correoRequest.setEmail(email);
        correoRequest.setTelefono(telefono);
        correoRequest.setMensaje(mensaje);

        // Lógica para procesar el archivo si es necesario
        if (archivo != null && !archivo.isEmpty()) {
            // Procesar el archivo aquí si es necesario
        }

        // Enviar el correo electrónico
        correoService.enviarCorreo(correoRequest);
        return "/contacto/salida";
    }
}
