package com.cg.ata.controller;

import com.cg.ata.service.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/driver")
public class DriverController {

    @Autowired
    private DriverServiceImpl driverService;


}
