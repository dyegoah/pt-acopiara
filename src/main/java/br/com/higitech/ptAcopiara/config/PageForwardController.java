package br.com.higitech.ptAcopiara.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageForwardController {

    @GetMapping("/login")
    public String login() {
        return "forward:/login.html";
    }

    @GetMapping("/admin")
    public String admin() {
        return "forward:/admin.html";
    }
}
