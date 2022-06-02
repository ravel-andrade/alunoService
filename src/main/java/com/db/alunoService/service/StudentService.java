package com.db.alunoService.service;

import com.db.alunoService.model.StudentEntity;

import java.util.*;

public class StudentService {
    public Map<Double, List<StudentEntity>> getStudentsPerGrade(List<StudentEntity> students){
        Map<Double, List<StudentEntity>> studentsPerGrade = new HashMap<>();
        for (StudentEntity studentEntity : students) {
            if(studentsPerGrade.get(studentEntity.getNota()) == null){
                addStudentForNewGrade(studentsPerGrade, studentEntity);
            }else{
                addStudentForExistingGrade(studentsPerGrade, studentEntity);
            }
        }
        return studentsPerGrade;
    }

    public List<StudentEntity> removeDeduplicationFromList(List<StudentEntity> studentsFromController) {
        List<StudentEntity> students = new ArrayList<StudentEntity>();
        Set<StudentEntity> setStudents = new HashSet<StudentEntity>();
        setStudents.addAll(studentsFromController);
        students.addAll(setStudents);
        return students;
    }

    private void addStudentForExistingGrade(Map<Double, List<StudentEntity>> studentsPerGrade, StudentEntity studentEntity) {
        studentsPerGrade.get(studentEntity.getNota()).add(studentEntity);
    }

    private void addStudentForNewGrade(Map<Double, List<StudentEntity>> studentsPerGrade, StudentEntity studentEntity) {
        List<StudentEntity> newEntry = new ArrayList<>();
        newEntry.add(studentEntity);
        studentsPerGrade.put(studentEntity.getNota(), newEntry);
    }
}
