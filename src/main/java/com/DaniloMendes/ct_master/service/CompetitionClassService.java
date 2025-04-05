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

    public List<CompetitionClass> getAllClasses() {
        return competitionClassRepository.findAll();
    }

    public Optional<CompetitionClass> getClassById(Long id) {
        return competitionClassRepository.findById(id);
    }

    public CompetitionClass saveClass(CompetitionClass competitionClass) {
        return competitionClassRepository.save(competitionClass);
    }

    public void deleteClass(Long id) {
        competitionClassRepository.deleteById(id);
    }
}