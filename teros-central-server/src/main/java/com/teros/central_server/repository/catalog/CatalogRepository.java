package com.teros.central_server.repository.catalog;

import com.teros.central_server.entity.catalog.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
