package com.db.alunoService.service;

import com.db.alunoService.model.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {
    StudentService service = new StudentService();

    @Test
    void shouldRemoveDeduplicationFromStudentsList() {
        List<StudentEntity> expectedResult = buildStudentsList();
        List<StudentEntity> result = service.removeDeduplicationFromList(buildStudentsListWithDeduplication());
        assertEquals(expectedResult, result);
    }

    @Test
    void shouldGetStudentsListPerGrade() {
        Map<Double, List<StudentEntity>> expectedResult = buildResultMap();
        Map<Double, List<StudentEntity>> result = service.getStudentsPerGrade(buildStudentsList());
        assertEquals(expectedResult, result);
    }

    private Map<Double, List<StudentEntity>> buildResultMap() {
        Map<Double, List<StudentEntity>> resultMap = new HashMap<>();
        List<StudentEntity> studentsWithHigherGrade = new ArrayList<>();
        studentsWithHigherGrade.add(new StudentEntity(9.1, "Lucas"));
        List<StudentEntity> studentsWithLowerGrade = new ArrayList<>();
        studentsWithLowerGrade.add(new StudentEntity(8.1, "Felipe"));
        studentsWithLowerGrade.add(new StudentEntity(8.1, "Ravel"));
        resultMap.put(8.1, studentsWithLowerGrade);
        resultMap.put(9.1, studentsWithHigherGrade);
        return resultMap;
    }

    private List<StudentEntity> buildStudentsList() {
        List<StudentEntity> studentsList = new ArrayList<>();
        studentsList.add(new StudentEntity(8.1, "Felipe"));
        studentsList.add(new StudentEntity(9.1, "Lucas"));
        studentsList.add(new StudentEntity(8.1, "Ravel"));
        return studentsList;
    }

    private List<StudentEntity> buildStudentsListWithDeduplication() {
        List<StudentEntity> studentsList = new ArrayList<>();
        studentsList.add(new StudentEntity(8.1, "Ravel"));
        studentsList.add(new StudentEntity(8.1, "Ravel"));
        studentsList.add(new StudentEntity(8.1, "Ravel"));
        studentsList.add(new StudentEntity(8.1, "Felipe"));
        studentsList.add(new StudentEntity(9.1, "Lucas"));
        return studentsList;
    }
}
