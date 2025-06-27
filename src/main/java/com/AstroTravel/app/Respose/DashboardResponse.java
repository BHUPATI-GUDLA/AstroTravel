package com.AstroTravel.app.Respose;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    private String name;
    private String emailId;
    private String result;
}
