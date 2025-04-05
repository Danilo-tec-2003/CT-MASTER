package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.CommercialClass;
import com.DaniloMendes.ct_master.repository.CommercialClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommercialClassService {

    @Autowired
    private CommercialClassRepository commercialClassRepository;

    public List<CommercialClass> getAllClasses() {
        return commercialClassRepository.findAll();
    }

    public Optional<CommercialClass> getClassById(Long id) {
        return commercialClassRepository.findById(id);
    }

    public CommercialClass saveClass(CommercialClass commercialClass) {
        return commercialClassRepository.save(commercialClass);
    }

    public void deleteClass(Long id) {
        commercialClassRepository.deleteById(id);
    }
}