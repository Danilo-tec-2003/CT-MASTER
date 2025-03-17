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
public class TrialClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;  // Relacionamento com o aluno (não apenas o ID)

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;  // Relacionamento com o instrutor (não apenas o ID)

    @Column(nullable = false)
    private LocalDateTime scheduleDate;  // Data e hora do agendamento

    @Column(nullable = false)
    private boolean attended;  // Se o aluno compareceu ou não à aula
}
