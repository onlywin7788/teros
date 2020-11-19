package com.teros.api_control_manager.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteListModel {
    private String id;
    private List predicates;
    private List<String> filters;
    private String uri;

    @Builder
    public RouteListModel() {
    }
}