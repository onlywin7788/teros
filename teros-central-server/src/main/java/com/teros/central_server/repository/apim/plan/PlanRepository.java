package com.teros.central_server.repository.apim.plan;

import com.teros.central_server.entity.apim.plan.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}
