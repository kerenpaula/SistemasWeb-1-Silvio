package br.com.projetoescola.escola.controller;


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

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cidades", cidadeService.listarTodas());
        return "cidades/lista"; 
    }

    @GetMapping("/nova")
    public String novaCidadeForm(Model model) {
        model.addAttribute("cidade", new Cidade());
        return "cidades/form";
    }

    @PostMapping("/salvar")
    public String salvarCidade(@ModelAttribute Cidade cidade) {
        cidadeService.salvar(cidade);
        return "redirect:/cidades";
    }

    @GetMapping("/editar/{id}")
    public String editarCidade(@PathVariable Integer id, Model model) {
        model.addAttribute("cidade", cidadeService.buscarPorId(id));
        return "cidades/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCidade(@PathVariable Integer id) {
        cidadeService.excluir(id);
        return "redirect:/cidades";
    }
}

