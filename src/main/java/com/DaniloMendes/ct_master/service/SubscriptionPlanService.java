package com.DaniloMendes.ct_master.service;

import com.DaniloMendes.ct_master.model.SubscriptionPlan;
import com.DaniloMendes.ct_master.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository repository;

    public SubscriptionPlan savePlan(SubscriptionPlan plan) {
        return repository.save(plan);
    }

    public List<SubscriptionPlan> getAllPlans() {
        return repository.findAll();
    }

    public Optional<SubscriptionPlan> getPlanById(Long id) {
        return repository.findById(id);
    }
}