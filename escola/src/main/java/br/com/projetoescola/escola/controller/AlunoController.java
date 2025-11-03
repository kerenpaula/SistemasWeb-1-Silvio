package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoescola.escola.dto.AlunoCurso;
import br.com.projetoescola.escola.dto.AlunoTelefone;
import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.service.AlunoService;
import br.com.projetoescola.escola.service.CidadeService;
import br.com.projetoescola.escola.service.CursoService;



@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    // Injeção de dependencia da service de alunos
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CidadeService cidadeService;

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
       
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);

        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        
        return "aluno/formularioAluno";
    }

    // Método par abrir o formulário de edição de alunos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable ("id") Integer id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "aluno/formularioAluno";
    }


    // Método para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id){
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }

     // Método para listar nome e telefone de alunos (DTO)
    @GetMapping("/listar-nome-telefone")
    public String buscarNomeTelefone(Model model) {
        List <AlunoTelefone> alunos = alunoService.buscarNomeTelefone();
        model.addAttribute("alunos", alunos);
        return "aluno/listaNomeTelefone";
        
    }

    // Método para listar nome e curso de alunos (DTO)
    @GetMapping("/listar-nome-curso")
    public String buscarNomeCurso(Model model) {
        List <AlunoCurso> alunos = alunoService.buscarNomeCurso();
        model.addAttribute("alunos", alunos);
        return "aluno/listaNomeCurso";
        
    }

    
    
   
    
}

