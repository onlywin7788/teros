package com.teros.central_server.service.apim.request.manager;

import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.entity.apim.request.manager.RouteUIDEntity;
import com.teros.central_server.repository.apim.request.manager.RouteRepository;
import com.teros.central_server.repository.apim.request.manager.RouteUIDRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteUIDRepository routeUIDRepository;

    public RouteService(RouteRepository routeRepository, RouteUIDRepository routeUIDRepository) {
        this.routeRepository = routeRepository;
        this.routeUIDRepository = routeUIDRepository;
    }

    public RouteUIDEntity getRouteUID()
    {
        return routeUIDRepository.getRouteUIDEntity();
    }

    public List<RouteEntity> getRouteList()
    {
        return routeRepository.getRouteEntity();
    }
}
