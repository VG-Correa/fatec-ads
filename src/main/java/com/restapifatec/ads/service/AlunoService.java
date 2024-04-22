package com.restapifatec.ads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapifatec.ads.model.Aluno;
import com.restapifatec.ads.repository.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    AlunoRepository alunoRepository;


    public List<Aluno> finAllAlunos(){
        return alunoRepository.findAll();
    }

}
