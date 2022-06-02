package com.db.alunoService.controller;

import com.db.alunoService.model.StudentEntity;
import com.db.alunoService.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/pornota")
    public @ResponseBody Map<Double, List<StudentEntity>> getStudentsPerGrade(@RequestBody List<StudentEntity> studentsFromRequest){
        List<StudentEntity> students = studentService.removeDeduplicationFromList(studentsFromRequest);
        return studentService.getStudentsPerGrade(students);
    }
}
