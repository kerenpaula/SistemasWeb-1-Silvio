package br.com.projetoescola.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.projetoescola.escola.dto.AlunoTelefone;
import br.com.projetoescola.escola.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

       // Listar nomes e telefones de alunos
    @Query("SELECT new br.com.projetoescola.escola.dto.AlunoTelefone(a.nomeAluno, a.telefoneAluno) FROM Aluno a") List <AlunoTelefone> buscarNomeTelefone();
    
    
}
