package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    List<Instructor> findByName(String name); // Buscar instrutores pelo nome

    List<Instructor> findBySpecialtiesContaining(String specialty); // Buscar instrutores por especialidade
}
