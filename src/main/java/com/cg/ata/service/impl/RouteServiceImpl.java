package com.cg.ata.service.impl;

import com.cg.ata.exception.RouteNotFoundException;
import com.cg.ata.model.Route;
import com.cg.ata.repository.RouteRepository;
import com.cg.ata.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void addRoute(Route route) {
        routeRepository.save(route);
    }

    @Override
    public void updateRoute(Long routeId, Route route) {
        Route obj = routeRepository.findById(routeId).orElseThrow(
                ()-> new RouteNotFoundException("Route not found with id : "+routeId));
        obj.setSource(route.getSource());
        obj.setDestination(route.getDestination());
        obj.setDistance(route.getDistance());
        obj.setDuration(route.getDuration());

        Route updatedRoute =routeRepository.save(obj);

    }

    @Override
    public void deleteRoute(Long routeId) {
        Route route = routeRepository.findById(routeId).orElseThrow(
                () -> new RouteNotFoundException("Route not found with id : " + routeId));

    routeRepository.deleteById(routeId);
   }

    @Override
    public Route viewRoute(Long routeId) {
        return routeRepository.findById(routeId).orElseThrow(
                () -> new RouteNotFoundException("Route not found with id : " + routeId));
    }

    @Override
    public List<Route> viewAllRoutes() {
        List<Route> routeList = routeRepository.findAll();
        if(routeList.size()>0)
            return routeList;
        else
            throw new RouteNotFoundException("No routes found in database");
    }
}
