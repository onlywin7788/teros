package com.teros.central_server.controller.api.v1.apim.request.manager;

import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.model.response.ListResult;
import com.teros.central_server.service.apim.api.APIService;
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
    private final APIService apiService;

    public RouteRestController(RouteService routeService, ResponseService responseService, APIService apiService) {
        this.routeService = routeService;
        this.responseService = responseService;
        this.apiService = apiService;
    }

    @GetMapping(value = "/request/manager/routes/{request_uid}")
    public ListResult<RouteEntity> getRouteList(@PathVariable String request_uid, HttpServletResponse response) {

        if(apiService.getCount() > 0) {
            String routeUid = routeService.getRouteUID().getRouteUid();

            if (routeUid.equals(request_uid) == true)
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            else
                log.info(String.format("route-original-uid:[%s] / route-request-uid=:[%s]", routeUid, request_uid));

            response.addHeader("router-request-uid", routeUid);
        }
        else
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);

        return responseService.getListResult(routeService.getRouteList());

    }
}