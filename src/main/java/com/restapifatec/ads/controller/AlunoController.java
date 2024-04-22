package com.restapifatec.ads.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapifatec.ads.model.Aluno;
import com.restapifatec.ads.repository.AlunoRepository;
import com.restapifatec.ads.service.AlunoService;

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
    public ResponseEntity<String> postAluno(@RequestBody MultiValueMap<String, String> request) {

        System.out.println(request.getFirst("nome"));



        return null;

    }



}
