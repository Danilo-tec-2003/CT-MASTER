package com.DaniloMendes.ct_master.controller;

import com.DaniloMendes.ct_master.model.SubscriptionPlan;
import com.DaniloMendes.ct_master.service.SubscriptionPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Libera CORS para o frontend
@RestController
@RequestMapping("/api/subscription-plans") // Caminho base do endpoint
@Tag(name = "Planos de Inscrição", description = "Gerencia planos de assinatura")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService service;

    @Operation(summary = "Criar um novo plano")
    @PostMapping
    public ResponseEntity<SubscriptionPlan> createPlan(@RequestBody SubscriptionPlan plan) {
        SubscriptionPlan savedPlan = service.savePlan(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlan);
    }

    // Outros endpoints (opcionais, mas recomendados)
    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return service.getAllPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlan> getPlanById(@PathVariable Long id) {
        return service.getPlanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}