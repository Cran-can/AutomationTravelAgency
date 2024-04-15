package com.cg.ata.service;

import com.cg.ata.model.Route;

import java.util.List;


public interface RouteService {
    public void addRoute(Route route);
    public void updateRoute(Long routeId,Route route);
    public void deleteRoute(Long routeId);
    public Route viewRoute(Long routeId);
    public List<Route> viewAllRoutes();
}
