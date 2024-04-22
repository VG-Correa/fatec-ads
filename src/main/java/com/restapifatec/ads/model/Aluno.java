package com.restapifatec.ads.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    private boolean matriculado;
    
    @OneToMany
    @JoinColumn(name = "aluno_id")
    private List<Nota> notas = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco Endereco;

}
