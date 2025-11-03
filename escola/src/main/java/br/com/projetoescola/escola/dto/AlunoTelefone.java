package br.com.projetoescola.escola.dto;

public class AlunoTelefone {

    private String nomePessoa;
    private String telefoneAluno;
    
    public AlunoTelefone() {
    }

    public AlunoTelefone(String nomePessoa, String telefoneAluno) {
        this.nomePessoa = nomePessoa;
        this.telefoneAluno = telefoneAluno;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }


    
    
}
