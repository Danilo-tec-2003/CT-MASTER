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
public class TrialClassSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;  // ID do aluno que está agendando a aula experimental

    private Long instructorId;  // ID do instrutor responsável pela aula

    private LocalDateTime scheduleDate;  // Data e hora agendada para a aula experimental

    private boolean attended;  // Indicador de se o aluno compareceu à aula ou não
}
