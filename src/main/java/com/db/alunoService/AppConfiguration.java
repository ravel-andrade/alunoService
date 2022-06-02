package com.db.alunoService;

import com.db.alunoService.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public StudentService studentService(){
        return new StudentService();
    }

}
