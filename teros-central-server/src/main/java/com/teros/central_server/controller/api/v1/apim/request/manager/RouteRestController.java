package com.teros.central_server.controller.api.v1.apim.request.manager;

import com.teros.central_server.entity.apim.api.APIEntity;
import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.service.apim.request.manager.RouteService;
import com.teros.central_server.service.apim.response.ResponseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"MANAGER-ROUTE-LIST"})
@RestController
@RequestMapping(value = "/v1")
public class RouteRestController {

    private final RouteService routeService;
    private final ResponseService responseService;

    public RouteRestController(RouteService routeService, ResponseService responseService) {
        this.routeService = routeService;
        this.responseService = responseService;
    }

    @GetMapping(value = "/request/manager/routes")
    public ListResult<RouteEntity> getRouteList() {
        return responseService.getListResult(routeService.getRouteList());
    }

}