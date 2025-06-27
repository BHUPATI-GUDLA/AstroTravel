package com.AstroTravel.app.Controller;

import com.AstroTravel.app.DTO.DashboardDTO;
import com.AstroTravel.app.Respose.GenericResponse;
import com.AstroTravel.app.services.DashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(allowedHeaders = "*")
public class DashboardController {

    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private DashboardService dashboardService;

    @PostMapping("/create-order")
    public GenericResponse<?> createOrder(@RequestBody DashboardDTO dashboardDTO) {
        return dashboardService.createOrder(dashboardDTO);
    }

}
