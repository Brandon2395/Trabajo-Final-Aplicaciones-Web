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
@RequestMapping("/ecommerce")
public class EcommerceController {

    @GetMapping("listado")
    public String getContacto() {
        return "/ecommerce/listado";
    }
}
    
