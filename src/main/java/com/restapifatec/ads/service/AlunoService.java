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


    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }


    public Aluno findById(int id) {
        return alunoRepository.findById(id).get();
    }


    public boolean delete(int id) {
        alunoRepository.deleteById(id);
        return true;
    }

}
