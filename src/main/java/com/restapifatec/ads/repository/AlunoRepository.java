package com.restapifatec.ads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapifatec.ads.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
    
    
}
