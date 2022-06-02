package com.db.alunoService.model;

import java.util.Objects;

public class StudentEntity {
    String nome;
    Double nota;

    public StudentEntity(Double nota, String nome) {
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
        StudentEntity studentEntity = (StudentEntity) o;
        return Objects.equals(nome, studentEntity.nome) && Objects.equals(nota, studentEntity.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nota);
    }

    @Override
    public String toString() {
        return "{"+ "nome=" + nome +
                ", nota=" + nota +
                '}';
    }
}
