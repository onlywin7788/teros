package com.teros.central_server.repository.api;

import com.teros.central_server.entity.api.APIEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIRepository extends JpaRepository<APIEntity, Long> {
}
