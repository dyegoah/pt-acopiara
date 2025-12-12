package br.com.higitech.ptAcopiara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página pública inicial
    @GetMapping({"/", "/index"})
    public String index() {
        // Encaminha para o index.html dentro de /static
        return "/index.html";
    }

      
}
