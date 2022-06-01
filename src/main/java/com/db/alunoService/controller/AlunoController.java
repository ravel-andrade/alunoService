package com.db.alunoService.controller;
import com.db.alunoService.model.Aluno;
import com.db.alunoService.model.AlunoEntity;
import com.db.alunoService.service.AlunoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    AlunoService alunoService = new AlunoService();

    @RequestMapping(value = "/pornota")
    public @ResponseBody Map<Double, List<Aluno>> getAlunosPorNota(@RequestBody List<Aluno> alunos){
        return alunoService.getAlunosPorNota(alunos);
    }
}
