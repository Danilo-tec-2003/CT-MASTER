package com.DaniloMendes.ct_master.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LessonExperimental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;  // Nome do aluno experimental
    private String contact;      // Telefone/Email para contato
    private int age;             // Idade do aluno
    private String martialArt;  // Arte marcial de interesse (Jiu-Jitsu, Muay Thai, etc.)

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime schedule;  // Data e hora da aula experimental

    private boolean attended;   // Se o aluno compareceu ou não
    private String observations; // Observações adicionais
}