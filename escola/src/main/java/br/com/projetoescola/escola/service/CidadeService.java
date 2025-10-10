package br.com.projetoescola.escola.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetoescola.escola.repository.CidadeRepository;
import br.com.projetoescola.escola.entity.Cidade;



@Service
public class CidadeService {
    // Ingeção de dependencia do repositório de alunos
    @Autowired
    private CidadeRepository cidadeRepository;
    public List <Cidade> listarTodas(){
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Integer id){
        return cidadeRepository.findById(id).orElse(null);
    }

    public Cidade salvar(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public void excluir(Integer id){
        cidadeRepository.deleteById(id);
    }


}


