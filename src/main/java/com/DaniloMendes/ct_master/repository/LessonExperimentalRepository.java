package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.LessonExperimental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonExperimentalRepository extends JpaRepository<LessonExperimental, Long> {
    // Métodos customizados podem ser adicionados aqui
    // Exemplo: List<LessonExperimental> findByAttended(boolean attended);
}