package com.teros.central_server.repository.plan;

import com.teros.central_server.entity.plan.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
