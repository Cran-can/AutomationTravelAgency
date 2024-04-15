package com.cg.ata.controller;

import com.cg.ata.service.impl.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/route")
public class RouteController {

    @Autowired
    private RouteServiceImpl routeService;


}
