package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Aqui você pode adicionar consultas customizadas se necessário
}
