package com.teros.central_server.repository.apim.product;

import com.teros.central_server.entity.apim.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
