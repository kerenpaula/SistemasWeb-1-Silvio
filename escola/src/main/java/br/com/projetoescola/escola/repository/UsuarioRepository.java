package br.com.projetoescola.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoescola.escola.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}

