package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.TrialClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrialClassScheduleRepository extends JpaRepository<TrialClassSchedule, Long> {
}
