package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.TrialClassSchedule;
import com.DaniloMendes.ct_master.repository.TrialClassScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrialClassScheduleService {

    @Autowired
    private TrialClassScheduleRepository trialClassScheduleRepository;

    // Agendar uma aula experimental
    public TrialClassSchedule scheduleTrialClass(TrialClassSchedule trialClassSchedule) {
        return trialClassScheduleRepository.save(trialClassSchedule);
    }

    // Recuperar todos os agendamentos de aulas experimentais
    public List<TrialClassSchedule> getAllTrialClassSchedules() {
        return trialClassScheduleRepository.findAll();
    }

    // Buscar agendamento de aula experimental por ID
    public Optional<TrialClassSchedule> getTrialClassScheduleById(Long id) {
        return trialClassScheduleRepository.findById(id);
    }

    // Atualizar um agendamento de aula experimental
    public TrialClassSchedule updateTrialClassSchedule(Long id, TrialClassSchedule trialClassSchedule) {
        if (trialClassScheduleRepository.existsById(id)) {
            trialClassSchedule.setId(id);
            return trialClassScheduleRepository.save(trialClassSchedule);
        } else {
            return null; // Caso não encontre o agendamento para atualizar
        }
    }

    // Excluir um agendamento de aula experimental
    public void deleteTrialClassSchedule(Long id) {
        trialClassScheduleRepository.deleteById(id);
    }
}
