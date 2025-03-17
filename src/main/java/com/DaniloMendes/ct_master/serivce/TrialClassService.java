package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.TrialClass;
import com.DaniloMendes.ct_master.repository.TrialClassRepository;
import com.DaniloMendes.ct_master.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrialClassService {

    @Autowired
    private TrialClassRepository trialClassRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Método para criar uma aula experimental
    public TrialClass createTrialClass(TrialClass trialClass) {
        // Verifica se o aluno já tem 3 aulas experimentais agendadas
        long trialClassesCount = trialClassRepository.countByStudentId(trialClass.getStudent().getId());

        if (trialClassesCount >= 3) {
            throw new IllegalStateException("O aluno já agendou 3 aulas experimentais.");
        }

        // Salva a aula experimental no banco de dados
        return trialClassRepository.save(trialClass);
    }

    // Outros métodos de negócios, como encontrar uma aula específica ou remover aulas experimentais, podem ser adicionados aqui
}