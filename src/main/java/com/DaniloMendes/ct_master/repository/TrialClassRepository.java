package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.TrialClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrialClassRepository extends JpaRepository<TrialClass, Long> {
    long countByStudentId(Long studentId);  // Método customizado para contar aulas por aluno
}
