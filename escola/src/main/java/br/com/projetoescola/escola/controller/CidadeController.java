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

import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.service.CidadeService;
@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

     // Método para salvar curso
     @PostMapping("/salvar")
     public String salvar(@ModelAttribute Cidade cidade){
        cidadeService.salvar(cidade);
         return "redirect:/cursos/listar";
     }
     // Método para listar todos os cursos
     @GetMapping("/listar")
         public String listarTodas(Model model){
             List<Cidade> cidades = cidadeService.listarTodas();
             model.addAttribute("cidades" , cidades);
             return "curso/listasCurso";
         }
     
     // Método para abrir o formulário de cursos
     @GetMapping("/criar")
     public String criarForm(Model model){
         model.addAttribute("cidade", new Cidade());
         return "curso/formularioCurso";
     }
 
     // Método para abrir o formulário de edição de alunos
     @GetMapping("/editar/{id}")
     public String editarForm(@PathVariable ("id") Integer id, Model model){
        Cidade cidade = cidadeService.buscarPorId(id);
         model.addAttribute("cidade", cidade);
         return "curso/formularioCurso";
     }
 
     // Método para excluir um curso
     @GetMapping("/excluir/{id}")
     public String excluir(@PathVariable("id") Integer id){
        cidadeService.excluir(id);
         return "redirect:/cursos/listar";
     }

 
}

