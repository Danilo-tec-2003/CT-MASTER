package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.TrialClassBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrialClassBookingRepository extends JpaRepository<TrialClassBooking, Long> {

    List<TrialClassBooking> findByStudentId(Long studentId);

    Optional<TrialClassBooking> findByIdAndStudentId(Long id, Long studentId);
}
