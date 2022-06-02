package com.db.alunoService.controller;

import com.db.alunoService.AlunoServiceApplication;
import com.db.alunoService.model.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AlunoServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StundentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetStudentsByGrade() {
        Map<Double, List<StudentEntity>> expectedResult = buildResultMap();
        List<StudentEntity> students = new ArrayList<>();
        students.add(new StudentEntity(8.1, "Felipe"));
        students.add(new StudentEntity(9.1, "Lucas"));
        students.add(new StudentEntity(8.1, "Ravel"));
        Map responseEntity = this.restTemplate
                .postForObject("http://localhost:" + port + "/alunos/pornota", students, Map.class);
        assertEquals(responseEntity, expectedResult);
    }

    private Map buildResultMap() {
        Map resultMap = new LinkedHashMap<>();
        List<LinkedHashMap> studentsWithHigherGrade = new ArrayList<>();
        LinkedHashMap studentA = new LinkedHashMap<>();
        studentA.put("nome", "Lucas");
        studentA.put("nota", 9.1);
        LinkedHashMap studentB = new LinkedHashMap<>();
        studentB.put("nome", "Felipe");
        studentB.put("nota", 8.1);
        LinkedHashMap studentC = new LinkedHashMap<>();
        studentC.put("nome", "Ravel");
        studentC.put("nota", 8.1);
        studentsWithHigherGrade.add(studentA);
        List<LinkedHashMap> studentsWithLowerGrade = new ArrayList<>();
        studentsWithLowerGrade.add(studentB);
        studentsWithLowerGrade.add(studentC);
        resultMap.put("9.1", studentsWithHigherGrade);
        resultMap.put("8.1", studentsWithLowerGrade);
        return resultMap;
    }
}
