package com.bustrack.bustrack.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusResponse {
    private Long id;
    public String busnumber;
    private double latitude;
    private double longitude;
    private double eta;


}
