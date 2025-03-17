package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.Instructor;
import com.DaniloMendes.ct_master.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
@Tag(name = "Gerenciamento de Instrutores", description = "Operações para gerenciar instrutores no sistema")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Operation(summary = "Listar todos os instrutores", description = "Retorna uma lista de todos os instrutores cadastrados no sistema.")
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @Operation(summary = "Buscar instrutor por ID", description = "Retorna os detalhes de um instrutor específico baseado no seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Optional<Instructor> instructor = instructorService.getInstructorById(id);
        return instructor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Buscar instrutores por nome ou especialidade", description = "Retorna uma lista de instrutores com base no nome ou especialidade fornecida.")
    @GetMapping("/search")
    public List<Instructor> searchInstructors(@RequestParam(required = false) String name,
                                              @RequestParam(required = false) String specialty) {
        if (name != null) {
            return instructorService.getInstructorsByName(name);
        } else if (specialty != null) {
            return instructorService.getInstructorsBySpecialty(specialty);
        } else {
            return instructorService.getAllInstructors();
        }
    }

    @Operation(summary = "Criar um novo instrutor", description = "Cria um novo instrutor no sistema.")
    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.createInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInstructor);
    }

    @Operation(summary = "Atualizar instrutor", description = "Atualiza os detalhes de um instrutor existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        return updatedInstructor != null ? ResponseEntity.ok(updatedInstructor)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(summary = "Excluir instrutor", description = "Exclui um instrutor do sistema com base no ID fornecido.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
