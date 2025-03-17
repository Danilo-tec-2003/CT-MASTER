package com.DaniloMendes.ct_master.service;  // Corrigido para 'service'

import com.DaniloMendes.ct_master.model.TrialClassBooking;
import com.DaniloMendes.ct_master.repository.TrialClassBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrialClassBookingService {

    @Autowired
    private TrialClassBookingRepository trialClassBookingRepository;

    public List<TrialClassBooking> getBookingsByStudentId(Long studentId) {
        return trialClassBookingRepository.findByStudentId(studentId);
    }

    public Optional<TrialClassBooking> getBookingByIdAndStudentId(Long id, Long studentId) {
        return trialClassBookingRepository.findByIdAndStudentId(id, studentId);
    }

    public TrialClassBooking createBooking(TrialClassBooking booking) {
        return trialClassBookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        trialClassBookingRepository.deleteById(id);
    }

}
