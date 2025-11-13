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

    public Usuario(){
        
    }

    public Usuario(Integer idUsuario, String nomeUsuario, String cpfUsuario, String senha, String login, String role) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.senha = senha;
        this.login = login;
        this.role = role;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
    
