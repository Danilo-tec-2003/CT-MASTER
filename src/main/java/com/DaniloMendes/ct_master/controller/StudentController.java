package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.Student;
import com.DaniloMendes.ct_master.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Gerenciamento de Alunos", description = "Operações para gerenciar alunos no sistema")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista de todos os alunos cadastrados no sistema.")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Buscar aluno por ID", description = "Retorna os detalhes de um aluno específico baseado no seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Criar um novo aluno", description = "Cria um novo aluno no sistema.")
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @Operation(summary = "Excluir aluno", description = "Exclui um aluno do sistema com base no ID fornecido.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
