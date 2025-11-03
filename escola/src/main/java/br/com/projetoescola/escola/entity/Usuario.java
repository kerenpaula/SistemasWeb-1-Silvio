package br.com.projetoescola.escola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer idUsuario;

    
    @Column(nullable = false, length = 60)
    private String nomeUsuario;

    @Column(nullable = false, length = 11)
    private String cpfUsuario;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = false, unique = true, length = 50)
    private String login;

    @Column(nullable = false, length = 20)
    private String role;


}
    
