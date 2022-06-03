package com.db.alunoService.service;

import com.db.alunoService.model.StudentEntity;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    public Map<Double, List<StudentEntity>> getStudentsPerGrade(List<StudentEntity> students){
        Map<Double, List<StudentEntity>> studentsPerGrade = new HashMap<>();
        students.stream().forEach(studentEntity -> {
            if(studentsPerGrade.get(studentEntity.getNota()) == null){
                List<StudentEntity> studentsWithSameGrade = students.stream()
                        .filter(student -> student.getNota().equals(studentEntity.getNota()))
                        .collect(Collectors.toList());
                studentsPerGrade.put(studentEntity.getNota(), studentsWithSameGrade);
            }
        });
        return studentsPerGrade;
    }

    public List<StudentEntity> removeDeduplicationFromList(List<StudentEntity> studentsFromController) {
        List<StudentEntity> students = new ArrayList<StudentEntity>();
        Set<StudentEntity> setStudents = new HashSet<StudentEntity>();
        setStudents.addAll(studentsFromController);
        students.addAll(setStudents);
        return students;
    }
}
