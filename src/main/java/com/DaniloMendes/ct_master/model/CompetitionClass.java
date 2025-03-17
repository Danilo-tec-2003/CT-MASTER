package com.DaniloMendes.ct_master.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompetitionClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className; // Nome da turma, ex: "Jiu-Jitsu - Preparação para Competição"

    private String description; // Descrição da turma

    private String schedule; // Horário das aulas, ex: "Segunda a Sexta, 19h às 21h"

    @ManyToOne
    private Instructor instructor; // Instrutor responsável pela turma

    @ManyToMany
    private List<Student> students; // Lista de alunos matriculados na turma
}
