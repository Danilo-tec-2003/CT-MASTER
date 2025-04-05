package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.LessonExperimental;
import com.DaniloMendes.ct_master.repository.LessonExperimentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonExperimentalService {

    @Autowired
    private LessonExperimentalRepository repository;

    public List<LessonExperimental> getAllLessons() {
        return repository.findAll();
    }

    public Optional<LessonExperimental> getLessonById(Long id) {
        return repository.findById(id);
    }

    public LessonExperimental saveLesson(LessonExperimental lesson) {
        return repository.save(lesson);
    }

    public void deleteLesson(Long id) {
        repository.deleteById(id);
    }
}