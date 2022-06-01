package com.db.alunoService.service;

import com.db.alunoService.model.Aluno;

import java.util.*;

public class AlunoService {
    public Map<Double, List<Aluno>> getAlunosPorNota(List<Aluno> alunosFromController){
        List<Aluno> alunos = removeDeduplication(alunosFromController);
        Map<Double, List<Aluno>> alunosPorNota = new HashMap<>();
        for (Aluno aluno: alunos) {
            if(alunosPorNota.get(aluno.getNota()) == null){
                List<Aluno> newEntry = new ArrayList<>();
                newEntry.add(aluno);
                alunosPorNota.put(aluno.getNota(), newEntry);
            }else{
                List<Aluno> listFromMap = alunosPorNota.get(aluno.getNota());
                listFromMap.add(aluno);
                alunosPorNota.replace(aluno.getNota(), listFromMap);
            }
        }
        return alunosPorNota;
    }

    private List<Aluno> removeDeduplication(List<Aluno> alunosFromController) {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Set<Aluno> setAlunos = new HashSet<Aluno>();
        setAlunos.addAll(alunosFromController);
        alunos.addAll(setAlunos);
        return alunos;
    }
}
