package com.AstroTravel.app.services;

import com.AstroTravel.app.Controller.DashboardController;
import com.AstroTravel.app.DTO.DashboardDTO;
import com.AstroTravel.app.Respose.DashboardResponse;
import com.AstroTravel.app.Respose.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private static final Logger log = LoggerFactory.getLogger(DashboardService.class);

    public GenericResponse<?> createOrder(DashboardDTO dashboardDTO) {
        log.info(dashboardDTO.toString());
        log.info("Order id - " + dashboardDTO.getOrderId());
        log.info("Order created at " + dashboardDTO.getOrderCreateTime());
        DashboardResponse dashboardResponse = DashboardResponse.builder()
                .name(dashboardDTO.getPayerFirstName() + " " + dashboardDTO.getPayerLastName())
                .result("Dear "+dashboardDTO.getUserFirstName()+" You Can Travel On "+dashboardDTO.getBirthDate()+"/"+dashboardDTO.getBirthMonth()+"/"+dashboardDTO.getBirthYear())
                .emailId(dashboardDTO.getPayerEmailAddress()).build();
        return GenericResponse.builder().body(dashboardResponse).code(HttpStatus.OK.name()).message("Order is created").build();
    }

}
