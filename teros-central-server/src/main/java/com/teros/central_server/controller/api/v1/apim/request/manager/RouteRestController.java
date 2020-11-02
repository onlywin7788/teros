package com.teros.central_server.controller.api.v1.apim.request.manager;

import com.teros.central_server.entity.apim.api.APIEntity;
import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.entity.apim.request.manager.RouteUIDEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.model.response.SingleResult;
import com.teros.central_server.service.apim.request.manager.RouteService;
import com.teros.central_server.service.apim.response.ResponseService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
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

    @GetMapping(value = "/request/manager/routes/{request_uid}")
    public ListResult<RouteEntity> getRouteList(@PathVariable String request_uid, HttpServletResponse response) {
        String routeUid = routeService.getRouteUID().getRouteUid();

        log.info(String.format("route-original-uid:[%s] / route-request-uid=:[%s]", routeUid, request_uid));

        if (routeUid.equals(request_uid) == true)
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);

        response.addHeader("router-request-uid", routeUid);
        return responseService.getListResult(routeService.getRouteList());

    }
}