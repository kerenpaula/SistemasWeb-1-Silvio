package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.repository.CursoRepository;

@Service
public class CursoService {
    // Ingeção de dependencia do repositório de alunos
    @Autowired
    private CursoRepository cursoRepository;

    // Método para salvar um aluno
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Método para listar todos os alunos
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

}