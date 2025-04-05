package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.LessonExperimental;
import com.DaniloMendes.ct_master.service.LessonExperimentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
    @RequestMapping("/api/experimental-lessons")
@Tag(name = "Aulas Experimentais", description = "Gerenciamento de aulas experimentais para novos alunos")
public class LessonExperimentalController {

    @Autowired
    private LessonExperimentalService service;

    @Operation(summary = "Listar todas as aulas experimentais")
    @GetMapping
    public List<LessonExperimental> getAllLessons() {
        return service.getAllLessons();
    }

    @Operation(summary = "Buscar aula experimental por ID")
    @GetMapping("/{id}")
    public ResponseEntity<LessonExperimental> getLessonById(@PathVariable Long id) {
        Optional<LessonExperimental> lesson = service.getLessonById(id);
        return lesson.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Agendar nova aula experimental")
    @PostMapping
    public ResponseEntity<LessonExperimental> createLesson(@RequestBody LessonExperimental lesson) {
        LessonExperimental savedLesson = service.saveLesson(lesson);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLesson);
    }

    @Operation(summary = "Excluir aula experimental")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        service.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}