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
     public String save(@ModelAttribute Cidade cidade){
        cidadeService.save(cidade);
         return "redirect:/cidades/listar";
     }
     // Método para listar todos os cursos
     @GetMapping("/listar")
         public String findAll(Model model){
             List<Cidade> cidades = cidadeService.findAll();
             model.addAttribute("cidades" , cidades);
             return "cidades/listasCidade";
         }
     
     // Método para abrir o formulário de cursos
     @GetMapping("/criar")
     public String criarForm(Model model){
         model.addAttribute("cidade", new Cidade());
         return "cidades/formularioCidade";
     }
 
     // Método para abrir o formulário de edição de alunos
     @GetMapping("/editar/{id}")
     public String editarForm(@PathVariable ("id") Integer id, Model model){
        Cidade cidade = cidadeService.buscarPorId(id);
         model.addAttribute("cidade", cidade);
         return "cidades/formularioCidade";
     }
 
     // Método para excluir um curso
     @GetMapping("/excluir/{id}")
     public String deleteById(@PathVariable("id") Integer id){
        cidadeService.deleteById(id);
         return "redirect:/cidades/listar";
     }

 
}

