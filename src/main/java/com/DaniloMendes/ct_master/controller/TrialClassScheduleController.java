package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.TrialClassSchedule;
import com.DaniloMendes.ct_master.service.TrialClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trial-class-schedules")
@Tag(name = "Aulas Experimentais", description = "Gerencia os agendamentos de aulas experimentais para novos alunos")
public class TrialClassScheduleController {

    @Autowired
    private TrialClassScheduleService trialClassScheduleService;

    @PostMapping
    @Operation(summary = "Agendar uma aula experimental", description = "Cria um novo agendamento de aula experimental")
    public ResponseEntity<TrialClassSchedule> scheduleTrialClass(@RequestBody TrialClassSchedule trialClassSchedule) {
        TrialClassSchedule scheduledClass = trialClassScheduleService.scheduleTrialClass(trialClassSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduledClass);
    }

    @GetMapping
    @Operation(summary = "Listar todas as aulas experimentais", description = "Retorna uma lista de todas as aulas experimentais agendadas")
    public List<TrialClassSchedule> getAllTrialClassSchedules() {
        return trialClassScheduleService.getAllTrialClassSchedules();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um agendamento por ID", description = "Retorna os detalhes de um agendamento de aula experimental pelo ID")
    public ResponseEntity<TrialClassSchedule> getTrialClassScheduleById(@PathVariable Long id) {
        Optional<TrialClassSchedule> trialClassSchedule = trialClassScheduleService.getTrialClassScheduleById(id);
        return trialClassSchedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um agendamento", description = "Atualiza os detalhes de um agendamento de aula experimental pelo ID")
    public ResponseEntity<TrialClassSchedule> updateTrialClassSchedule(@PathVariable Long id, @RequestBody TrialClassSchedule trialClassSchedule) {
        TrialClassSchedule updatedClass = trialClassScheduleService.updateTrialClassSchedule(id, trialClassSchedule);
        return updatedClass != null ? ResponseEntity.ok(updatedClass) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um agendamento", description = "Remove um agendamento de aula experimental do sistema pelo ID")
    public ResponseEntity<Void> deleteTrialClassSchedule(@PathVariable Long id) {
        trialClassScheduleService.deleteTrialClassSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
