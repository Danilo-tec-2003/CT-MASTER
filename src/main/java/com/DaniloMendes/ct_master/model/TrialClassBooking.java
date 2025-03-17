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
public class TrialClassBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; // Relacionamento com a tabela de alunos

    private LocalDateTime bookingDate; // Data e hora do agendamento

    @Enumerated(EnumType.STRING)
    private TrialClassStatus status; // Status da aula (confirmada, pendente, cancelada)

    public enum TrialClassStatus {
        PENDING, CONFIRMED, CANCELLED
    }
}
