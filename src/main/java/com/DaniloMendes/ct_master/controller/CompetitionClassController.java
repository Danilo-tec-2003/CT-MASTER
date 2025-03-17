package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.CompetitionClass;
import com.DaniloMendes.ct_master.service.CompetitionClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competition-classes")
@Tag(name = "Turmas de Competição", description = "Gerenciamento das turmas de competição no sistema")
public class CompetitionClassController {

    @Autowired
    private CompetitionClassService competitionClassService;

    @Operation(summary = "Listar todas as turmas de competição", description = "Retorna uma lista de todas as turmas de competição cadastradas no sistema.")
    @GetMapping
    public List<CompetitionClass> getAllCompetitionClasses() {
        return competitionClassService.getAllCompetitionClasses();
    }

    @Operation(summary = "Buscar turma de competição por ID", description = "Retorna os detalhes de uma turma de competição específica com base no ID fornecido.")
    @GetMapping("/{id}")
    public ResponseEntity<CompetitionClass> getCompetitionClassById(@PathVariable Long id) {
        Optional<CompetitionClass> competitionClass = competitionClassService.getCompetitionClassById(id);
        return competitionClass.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Criar uma nova turma de competição", description = "Cria uma nova turma de competição no sistema.")
    @PostMapping
    public ResponseEntity<CompetitionClass> createCompetitionClass(@RequestBody CompetitionClass competitionClass) {
        CompetitionClass createdCompetitionClass = competitionClassService.createCompetitionClass(competitionClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompetitionClass);
    }

    @Operation(summary = "Atualizar turma de competição", description = "Atualiza os detalhes de uma turma de competição existente.")
    @PutMapping("/{id}")
    public ResponseEntity<CompetitionClass> updateCompetitionClass(@PathVariable Long id, @RequestBody CompetitionClass competitionClass) {
        CompetitionClass updatedCompetitionClass = competitionClassService.updateCompetitionClass(id, competitionClass);
        return updatedCompetitionClass != null ? ResponseEntity.ok(updatedCompetitionClass) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Excluir turma de competição", description = "Exclui uma turma de competição do sistema com base no ID fornecido.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetitionClass(@PathVariable Long id) {
        competitionClassService.deleteCompetitionClass(id);
        return ResponseEntity.noContent().build();
    }
}
