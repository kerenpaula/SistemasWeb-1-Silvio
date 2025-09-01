package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.service.AlunoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    // Injeção de dependencia da service de alunos
    @Autowired
    private AlunoService alunoService;

    // Método para salvar aluno
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno){
        alunoService.save(aluno);
        return "redirect:/alunos/listar";
    }
    // Método para listar todos os alunos
    @GetMapping("/listar")
        public String listar(Model model){
            List<Aluno> alunos = alunoService.findAll();
            model.addAttribute("alunos", alunos);
            return "aluno/listasAluno";
        }
    
    // Método para abrir o formulário de alunos
    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("aluno", new Aluno());
        return "aluno/formularioAluno";
    }
}
