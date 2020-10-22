package com.teros.central_server.controller.api.v1.apim.catalog;

import com.teros.central_server.entity.apim.catalog.CatalogEntity;
import com.teros.central_server.model.apim.catalog.ModelParamCatalog;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.catalog.CatalogService;
import com.teros.central_server.service.apim.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"CATALOG"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class CatalogRestController {

    @Autowired
    private CatalogService catalogService;
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/catalog/{id}")
    public SingleResult<CatalogEntity> getCatalog(@PathVariable long id) {
        return responseService.getSingleResult(catalogService.getCatalog(id));
    }

    @GetMapping(value = "/catalog")
    public ListResult<CatalogEntity> getCatalogList() {
        return responseService.getListResult(catalogService.getCatalogList());
    }

    @PostMapping(value = "/catalog")
    public void insertCatalog(@RequestBody ModelParamCatalog modelParamCatalog) {
        catalogService.saveCatalog(modelParamCatalog);
    }

    @PutMapping(value = "/catalog/{id}")
    public Long updateCatalog(@PathVariable long id, @RequestBody ModelParamCatalog modelParamCatalog) {
        return catalogService.updateCatalog(id, modelParamCatalog);
    }

    @DeleteMapping(value = "/catalog/{id}")
    public CommonResult deleteCatalog(@PathVariable long id) {
        boolean ret = catalogService.deleteCatalog(id);
        return responseService.getResult(ret);
    }
}