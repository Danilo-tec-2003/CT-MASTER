package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.Feedback;
import com.DaniloMendes.ct_master.service.FeedbackService;
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
@RequestMapping("/api/feedbacks")
@Tag(name = "Gerenciamento de Feedbacks", description = "Operações para gerenciar feedbacks dos alunos")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Operation(summary = "Listar todos os feedbacks", description = "Retorna uma lista de todos os feedbacks cadastrados no sistema.")
    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.getAllFeedbacks();
    }

    @Operation(summary = "Buscar feedback por ID", description = "Retorna os detalhes de um feedback específico baseado no seu ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Criar um novo feedback", description = "Cria um novo feedback no sistema.")
    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback savedFeedback = feedbackService.saveFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedback);
    }

    @Operation(summary = "Excluir feedback", description = "Exclui um feedback do sistema com base no ID fornecido.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar feedbacks por aluno", description = "Retorna todos os feedbacks de um aluno específico")
    @GetMapping("/student/{studentId}")
    public List<Feedback> getFeedbacksByStudent(@PathVariable Long studentId) {
        return feedbackService.getFeedbacksByStudentId(studentId);
    }
}