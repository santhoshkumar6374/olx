package com.bustrack.bustrack.service;

import com.bustrack.bustrack.dto.BusRequest;
import com.bustrack.bustrack.dto.BusResponse;
import com.bustrack.bustrack.dto.LocationUpdateRequest;
import com.bustrack.bustrack.entity.Bus;

import java.util.List;

public interface BusService {
    BusResponse createBus(BusRequest request);

    BusResponse getBus(String busnumber);
    List<Bus> getAllBus();

    BusResponse updateLocation(Long id, LocationUpdateRequest request);
}
