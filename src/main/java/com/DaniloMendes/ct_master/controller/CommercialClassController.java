package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.CommercialClass;
import com.DaniloMendes.ct_master.service.CommercialClassService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/commercial-classes")
@Tag(name = "Turmas Comerciais", description = "Gerenciamento de turmas para praticantes regulares")
public class CommercialClassController {

    @Autowired
    private CommercialClassService commercialClassService;

    @Operation(summary = "Listar turmas")
    @GetMapping
    public List<CommercialClass> getAllClasses() {
        return commercialClassService.getAllClasses();
    }

    @Operation(summary = "Buscar turma por ID")
    @GetMapping("/{id}")
    public ResponseEntity<CommercialClass> getClassById(@PathVariable Long id) {
        Optional<CommercialClass> clazz = commercialClassService.getClassById(id);
        return clazz.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Criar turma")
    @PostMapping
    public ResponseEntity<CommercialClass> createClass(@RequestBody CommercialClass commercialClass) {
        CommercialClass savedClass = commercialClassService.saveClass(commercialClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClass);
    }

    @Operation(summary = "Excluir turma")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id) {
        commercialClassService.deleteClass(id);
        return ResponseEntity.noContent().build();
    }
}