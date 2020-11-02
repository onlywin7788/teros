package com.teros.central_server.controller.api.v1.apim.product;

import com.teros.central_server.entity.apim.product.ProductEntity;
import com.teros.central_server.model.apim.product.ModelParamProduct;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.product.ProductService;
import com.teros.central_server.service.apim.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"PRODUCT"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class ProductRestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/product/{id}")
    public SingleResult<ProductEntity> getProduct(@PathVariable long id) {
        return responseService.getSingleResult(productService.getProduct(id));
    }

    @GetMapping(value = "/product")
    public ListResult<ProductEntity> getProductList() {
        return responseService.getListResult(productService.getProductList());
    }

    @PostMapping(value = "/product")
    public void insertProduct(@RequestBody ModelParamProduct modelParamProduct) {
        productService.saveProduct(modelParamProduct);
    }

    @PutMapping(value = "/product/{id}")
    public Long updateProduct(@PathVariable long id, @RequestBody ModelParamProduct modelParamProduct) {

        return productService.updateProduct(id, modelParamProduct);
    }

    @DeleteMapping(value = "/product/{id}")
    public CommonResult deleteProduct(@PathVariable long id) {
        boolean ret = productService.deleteProduct(id);
        return responseService.getResult(ret);
    }
}