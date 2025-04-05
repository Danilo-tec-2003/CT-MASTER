package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.CommercialClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialClassRepository extends JpaRepository<CommercialClass, Long> {
    // Métodos básicos do JPA já inclusos
}