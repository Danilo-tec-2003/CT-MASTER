package com.DaniloMendes.ct_master.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommercialClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String instructor;
    private String schedule; // Ex: "Segunda e Quarta, 19h"
    private int maxStudents;
    private String difficultyLevel; // Iniciante, Intermediário
}