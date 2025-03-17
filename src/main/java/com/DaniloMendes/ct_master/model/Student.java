package com.DaniloMendes.ct_master.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String levelExperience;
    private String martialArt;
    private String contact;

    @Column(length = 1000)
    private String healthSheet;  // Informações básicas de saúde

    private String modality;  // Ex: Aulas regulares, treino para competição
}

