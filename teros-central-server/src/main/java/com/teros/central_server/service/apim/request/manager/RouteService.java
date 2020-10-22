package com.teros.central_server.service.apim.request.manager;

import com.teros.central_server.entity.apim.request.manager.RouteEntity;
import com.teros.central_server.repository.apim.request.manager.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<RouteEntity> getRouteList()
    {
        return routeRepository.getRouteEntity();
    }
}
