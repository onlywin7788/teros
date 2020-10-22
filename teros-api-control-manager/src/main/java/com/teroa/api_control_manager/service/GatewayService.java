package com.teroa.api_control_manager.service;

import com.google.gson.Gson;
import com.teroa.api_control_manager.model.Route;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GatewayService {

    public Route getRoute(){

        Route route = Route.builder()
                .build();

        // set id
        route.setId("TEST");

        // set predicates
        HashMap predicatesMap = new HashMap();
        HashMap predicatesArgsMap = new HashMap();
        List predicatesList = new ArrayList();

        predicatesMap.put("name", "Method");
        predicatesArgsMap.put("type", "GET");
        predicatesMap.put("args", predicatesArgsMap);

        predicatesList.add(predicatesMap);
        route.setPredicates(predicatesList);

        // set filter
        List<String> filterList = new ArrayList<String>();
        filterList.add("RewritePath=/app500,/APIC/DATA.json");
        route.setFilters(filterList);

        // set uri
        route.setUri("http://10.10.2.250:8080");

        return route;
    }
}
