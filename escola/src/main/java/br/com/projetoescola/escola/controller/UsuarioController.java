package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.projetoescola.escola.entity.Usuario;
import br.com.projetoescola.escola.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    //Abrir formulário de criação
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/formularioUsuario"; 
    }

    //Salvar
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Usuario usuario) {
        
        usuarioService.save(usuario);
        return "/login";
    }

    
}
