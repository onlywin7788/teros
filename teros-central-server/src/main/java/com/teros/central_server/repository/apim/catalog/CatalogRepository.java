package com.teros.central_server.repository.apim.catalog;

import com.teros.central_server.entity.apim.catalog.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogEntity, Long> {
}
