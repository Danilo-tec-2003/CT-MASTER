package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.TrialClassBooking;
import com.DaniloMendes.ct_master.service.TrialClassBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@Tag(name = "Agendamentos de Aulas Experimentais", description = "Gerenciamento de agendamentos de aulas experimentais")
public class TrialClassBookingController {

    @Autowired
    private TrialClassBookingService trialClassBookingService;

    @Operation(summary = "Buscar agendamentos por ID do aluno", description = "Retorna uma lista de agendamentos de aulas experimentais para um aluno específico.")
    @GetMapping("/student/{studentId}")
    public List<TrialClassBooking> getBookingsByStudent(@PathVariable Long studentId) {
        return trialClassBookingService.getBookingsByStudentId(studentId);
    }

    @Operation(summary = "Buscar agendamento por ID e aluno", description = "Retorna um agendamento específico de aula experimental com base no ID e no aluno associado.")
    @GetMapping("/{id}/student/{studentId}")
    public ResponseEntity<TrialClassBooking> getBookingByIdAndStudent(@PathVariable Long id, @PathVariable Long studentId) {
        Optional<TrialClassBooking> booking = trialClassBookingService.getBookingByIdAndStudentId(id, studentId);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Criar um novo agendamento", description = "Registra um novo agendamento de aula experimental para um aluno.")
    @PostMapping
    public ResponseEntity<TrialClassBooking> createBooking(@RequestBody TrialClassBooking booking) {
        TrialClassBooking savedBooking = trialClassBookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @Operation(summary = "Excluir um agendamento", description = "Remove um agendamento de aula experimental pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        trialClassBookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
