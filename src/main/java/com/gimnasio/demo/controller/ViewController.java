// src/main/java/com/gimnasio/demo/controller/ViewController.java
package com.gimnasio.demo.controller;

import com.gimnasio.demo.model.Usuario;
import com.gimnasio.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ViewController {

    private final UsuarioRepository repo;

    public ViewController(UsuarioRepository repo) {
        this.repo = repo;
    }

    /**
     * 1) Al entrar a la raíz "/", muestro la página de inicio:
     */
    @GetMapping("/")
    public String homePage() {
        // Aquí devolvemos la plantilla "/"
        return "US_Inicio";
    }

    /**
     * 2) GET /login: muestro la página de login.
     */
    @GetMapping("/login")
    public String loginPage() {
        return "US_Login";
    }



    /**
     * 3) GET /register: muestro la página de registro.
     */
    @GetMapping("/register")
    public String registerPage() {
        return "US_Register";
    }

    /**
     * 4) GET /tablaUsuarios: muestro la tabla de usuarios (como antes).
     */
    @GetMapping("/tablaUsuarios")
    public String tablaUsuarios(Model model) {
        List<Usuario> usuarios = repo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "tablaUsuarios";
    }

    @GetMapping("/pagoA")
    public String pagoAPage() {
        return "US_PagoA";
    }

    @GetMapping("/pagoB")
    public String pagoBPage() {
        return "US_PagoB";
    }

    @GetMapping("/pagoC")
    public String pagoCPage() {
        return "US_PagoC";
    }
    // … si tienes más páginas (por ejemplo, US_Anuncios, US_PlanesYPrecios, etc.),
    // solo agrega más @GetMapping que devuelvan el nombre de la plantilla.
}
