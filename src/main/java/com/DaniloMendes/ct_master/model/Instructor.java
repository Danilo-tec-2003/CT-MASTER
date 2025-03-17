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
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nome do professor
    private String bio;  // Biografia ou descrição do professor

    @ElementCollection
    private List<String> specialties; // Lista de especialidades do professor (ex: Jiu-Jitsu, Muay Thai, etc.)

    @ElementCollection
    private List<String> availability; // Lista de horários de disponibilidade (ex: "Segunda-feira: 14:00 - 18:00")
}
