package com.DaniloMendes.ct_master.repository;

import com.DaniloMendes.ct_master.model.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
    List<SubscriptionPlan> findByActive(boolean active); // Filtra planos ativos/inativos
}