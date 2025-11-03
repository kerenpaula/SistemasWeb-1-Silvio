package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.projetoescola.escola.repository.CidadeRepository;
import br.com.projetoescola.escola.entity.Cidade;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Integer id) {
        return cidadeRepository.findById(id).orElse(null);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void deleteById(Integer id) {
        cidadeRepository.deleteById(id);
    }


}
