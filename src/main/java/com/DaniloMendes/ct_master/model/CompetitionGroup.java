package com.DaniloMendes.ct_master.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompetitionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modality;  // Ex: Jiu-Jitsu, MMA, Muay Thai
    private String schedule;  // Ex: Seg, Qua, Sex 19h às 21h

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}

