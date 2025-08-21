package br.com.projetoescola.escola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Curso {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer idCurso;

    @Column (nullable = false, length = 30)
    private String nomeCurso;

    @Column (nullable = false, length = 10)
    private String siglaCurso;

    @Column (nullable = false)
    private Integer CHCurso;

    @Column (nullable = false, length = 20)
    private String periodoCurso;

     // MÉTODOS CONSTRUTORES:

    public Curso() {
    }

    public Curso(Integer idCurso, String nomeCurso, String siglaCurso, Integer cHCurso, String periodoCurso) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.siglaCurso = siglaCurso;
        CHCurso = cHCurso;
        this.periodoCurso = periodoCurso;
    }

    // MÉTODOS SETERS E GETERS

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getSiglaCurso() {
        return siglaCurso;
    }

    public void setSiglaCurso(String siglaCurso) {
        this.siglaCurso = siglaCurso;
    }

    public Integer getCHCurso() {
        return CHCurso;
    }

    public void setCHCurso(Integer cHCurso) {
        CHCurso = cHCurso;
    }

    public String getPeriodoCurso() {
        return periodoCurso;
    }

    public void setPeriodoCurso(String periodoCurso) {
        this.periodoCurso = periodoCurso;
    }

    
}