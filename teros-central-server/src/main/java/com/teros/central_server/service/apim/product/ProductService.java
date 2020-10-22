package com.teros.central_server.service.apim.product;

import com.teros.central_server.controller.advice.exception.CommonException;
import com.teros.central_server.entity.apim.product.ProductEntity;
import com.teros.central_server.model.apim.product.ModelParamProduct;
import com.teros.central_server.repository.apim.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new CommonException("EX"));
    }

    public List<ProductEntity> getProductList()
    {
        return productRepository.findAll();
    }

    @Transactional
    public Long saveProduct(ModelParamProduct modelParamProduct) {
        ProductEntity product = ProductEntity.builder()
                .productName(modelParamProduct.getProductName())
                .catalogId(modelParamProduct.getCatalogId())
                .description(modelParamProduct.getDescription())
                .build();

        return productRepository.save(product).getProductId();
    }

    @Transactional
    public Long updateProduct(long id, ModelParamProduct modelParamProduct) {

        ProductEntity product = getProduct(id);
        product.update(modelParamProduct.getProductName(), modelParamProduct.getCatalogId(), modelParamProduct.getDescription());
        return id;
    }

    @Transactional
    public boolean deleteProduct(long id) {
        ProductEntity product = getProduct(id);
        if(product == null)
            return false;
        productRepository.delete(product);
        return true;
    }
}