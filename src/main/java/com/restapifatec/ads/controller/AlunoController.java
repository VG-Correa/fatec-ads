package com.restapifatec.ads.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapifatec.ads.model.Aluno;
import com.restapifatec.ads.repository.AlunoRepository;
import com.restapifatec.ads.service.AlunoService;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @GetMapping("")
    public List<Aluno> getAlunos(){
        List<Aluno> alunos = alunoService.finAllAlunos();
        return alunos;
    }

    @PostMapping("")
    public ResponseEntity<Aluno> postAluno(@RequestBody MultiValueMap<String, String> request) {

        Aluno aluno = new Aluno();
        aluno.setId(Integer.parseInt(request.getFirst("id")));
        aluno.setNome(request.getFirst("nome"));
        aluno.setIdade(Integer.parseInt(request.getFirst("idade")));
        aluno.setMatriculado(Boolean.parseBoolean(request.getFirst("matriculado")));
        aluno.setCurso(request.getFirst("curso"));
        
        aluno = alunoService.save(aluno);

        return ResponseEntity.ok().body(aluno);

    }

    @PostMapping("update")
    @Transactional
    public ResponseEntity<Aluno> updateAluno(@RequestBody MultiValueMap<String, String> request) {
        Aluno aluno = alunoService.findById(Integer.parseInt(request.getFirst("id")));
        aluno.setNome(request.getFirst("nome"));
        aluno.setIdade(Integer.parseInt(request.getFirst("idade")));
        aluno.setMatriculado(Boolean.parseBoolean(request.getFirst("matriculado")));
        aluno.setCurso(request.getFirst("curso"));
    
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping("delete")
    public String deleteAluno(@RequestBody MultiValueMap<String, String> request) {
        if(alunoService.delete(Integer.parseInt(request.getFirst("id")))) {
            return "Aluon deletado";
        } else {
            return "Erro ao deletar usuario";
        }
    }

}
