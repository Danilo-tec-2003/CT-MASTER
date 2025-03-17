package com.DaniloMendes.ct_master.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePlan;  // Ex: Básico, Avançado, Competição
    private BigDecimal value;
    private String benefits;  // Ex: "Acesso ilimitado às aulas", "Treino individualizado"
}
