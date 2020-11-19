package com.teros.api_control_manager.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class RouteModel {
    private String requestRouteUid;
    private ArrayList<RouteListModel> routeList;
}