package com.teros.central_server.controller.api.v1.apim.api;

import com.teros.central_server.entity.apim.api.APIPathEntity;
import com.teros.central_server.model.apim.api.ModelParamAPIPath;
import com.teros.central_server.model.response.CommonResult;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.api.APIPathService;
import com.teros.central_server.service.apim.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API-PATH"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class APIPathRestController {

    @Autowired
    private APIPathService apiPathService;
    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/api-path/{id}")
    public SingleResult<APIPathEntity> getAPIPath(@PathVariable long id) {
        return responseService.getSingleResult(apiPathService.getAPIPath(id));
    }

    @GetMapping(value = "/api-path-by-api-id/{id}")
    public ListResult<APIPathEntity> getAPIPathByApiId(@PathVariable long id) {
        return responseService.getListResult(apiPathService.getAPIPathByApiId(id));
    }

    @GetMapping(value = "/api-path")
    public ListResult<APIPathEntity> getAPIPathList() {
        return responseService.getListResult(apiPathService.getAPIPathList());
    }

    @PostMapping(value = "/api-path")
    public void insertAPI(@RequestBody ModelParamAPIPath param) {
        apiPathService.saveAPIPath(param);
    }

    @PutMapping(value = "/api-path/{id}")
    public Long updateAPIPath(@PathVariable long id, @RequestBody ModelParamAPIPath param) {
        return apiPathService.updateAPIPath(id, param);
    }

    @DeleteMapping(value = "/api-path/{id}")
    public CommonResult deleteAPIPath(@PathVariable long id) {
        boolean ret = apiPathService.deleteAPIPath(id);
        return responseService.getResult(ret);
    }

    @DeleteMapping(value = "/api-path-by-api-id/{id}")
    public CommonResult deleteAPIPathByApiId(@PathVariable long id) {
        boolean ret = apiPathService.deleteAPIPathListByApiId(id);
        return responseService.getResult(ret);
    }
}