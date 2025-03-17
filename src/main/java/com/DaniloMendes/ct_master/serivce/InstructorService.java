package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.Instructor;
import com.DaniloMendes.ct_master.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public List<Instructor> getInstructorsByName(String name) {
        return instructorRepository.findByName(name);
    }

    public List<Instructor> getInstructorsBySpecialty(String specialty) {
        return instructorRepository.findBySpecialtiesContaining(specialty);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructor) {
        if (instructorRepository.existsById(id)) {
            instructor.setId(id);
            return instructorRepository.save(instructor);
        }
        return null;
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}
