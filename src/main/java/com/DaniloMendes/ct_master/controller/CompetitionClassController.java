package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.CompetitionClass;
import com.DaniloMendes.ct_master.service.CompetitionClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competition-classes")
@Tag(name = "Turmas de Competição", description = "Gerenciamento de turmas para atletas de competição")
public class CompetitionClassController {

    @Autowired
    private CompetitionClassService competitionClassService;

    @Operation(summary = "Listar turmas de competição")
    @GetMapping
    public List<CompetitionClass> getAllClasses() {
        return competitionClassService.getAllClasses();
    }

    @Operation(summary = "Buscar turma de competição por ID")
    @GetMapping("/{id}")
    public ResponseEntity<CompetitionClass> getClassById(@PathVariable Long id) {
        Optional<CompetitionClass> clazz = competitionClassService.getClassById(id);
        return clazz.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Criar turma de competição")
    @PostMapping
    public ResponseEntity<CompetitionClass> createClass(@RequestBody CompetitionClass competitionClass) {
        CompetitionClass savedClass = competitionClassService.saveClass(competitionClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClass);
    }

    @Operation(summary = "Excluir turma de competição")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        competitionClassService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}