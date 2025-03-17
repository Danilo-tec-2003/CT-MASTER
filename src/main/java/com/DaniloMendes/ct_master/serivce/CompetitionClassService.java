package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.CompetitionClass;
import com.DaniloMendes.ct_master.repository.CompetitionClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionClassService {

    @Autowired
    private CompetitionClassRepository competitionClassRepository;

    // Recuperar todas as turmas de competição
    public List<CompetitionClass> getAllCompetitionClasses() {
        return competitionClassRepository.findAll();
    }

    // Buscar uma turma de competição por ID
    public Optional<CompetitionClass> getCompetitionClassById(Long id) {
        return competitionClassRepository.findById(id);
    }

    // Criar uma nova turma de competição
    public CompetitionClass createCompetitionClass(CompetitionClass competitionClass) {
        return competitionClassRepository.save(competitionClass);
    }

    // Atualizar uma turma de competição existente
    public CompetitionClass updateCompetitionClass(Long id, CompetitionClass competitionClass) {
        if (competitionClassRepository.existsById(id)) {
            competitionClass.setId(id);
            return competitionClassRepository.save(competitionClass);
        } else {
            return null; // Caso não encontre a turma para atualizar
        }
    }

    // Excluir uma turma de competição por ID
    public void deleteCompetitionClass(Long id) {
        competitionClassRepository.deleteById(id);
    }
}
