package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.TrialClass;
import com.DaniloMendes.ct_master.service.TrialClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/trial-classes")
@Tag(name = "Trial Class", description = "Gerenciamento de aulas experimentais")
public class TrialClassController {

    @Autowired
    private TrialClassService trialClassService;

    @PostMapping
    @Operation(summary = "Agendar uma aula experimental", description = "Cria um novo agendamento de aula experimental no sistema.")
    public ResponseEntity<TrialClass> createTrialClass(@RequestBody TrialClass trialClass) {
        TrialClass createdTrialClass = trialClassService.createTrialClass(trialClass);
        return new ResponseEntity<>(createdTrialClass, HttpStatus.CREATED);
    }

    // Outros endpoints (GET, PUT, DELETE) podem ser adicionados conforme necessário
}