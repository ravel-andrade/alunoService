package com.db.alunoService.model;

import java.util.Objects;

public class Aluno {
    String nome;
    Double nota;

    public Aluno(Double nota, String nome) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome) && Objects.equals(nota, aluno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nota);
    }
}
