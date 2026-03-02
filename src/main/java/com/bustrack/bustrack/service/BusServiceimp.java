package com.bustrack.bustrack.service;

import com.bustrack.bustrack.dto.BusRequest;
import com.bustrack.bustrack.dto.BusResponse;
import com.bustrack.bustrack.dto.LocationUpdateRequest;
import com.bustrack.bustrack.entity.Bus;
import com.bustrack.bustrack.repository.BusRepository;
import com.bustrack.bustrack.util.DistanceUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceimp implements BusService{
    private final BusRepository busRepository;


    public BusServiceimp(BusRepository busRepository) {
        this.busRepository = busRepository;
    }
    @Override
    public BusResponse createBus(BusRequest request) {
        Bus bus= Bus.builder().busNumber(request.getBusnumber()).latitude(0.0).longitude(0.0).eta(0.0).build();
        busRepository.save(bus);
        return mapToResponse(bus);

    }
    public List<Bus> getAllBus(){
        return  busRepository.findAll();


    }
    @Override
    public BusResponse getBus(String busnumber) {
        Bus bus=busRepository.findByBusNumber(busnumber).orElseThrow(()-> new RuntimeException("Bus not found"));
        return mapToResponse(bus);

    }

    @Override
    public BusResponse updateLocation(Long id, LocationUpdateRequest request) {
        Bus bus=busRepository.findById(id).orElseThrow(()->new RuntimeException("Bus not found"));
        bus.setLatitude(request.getLatitude());
        bus.setLongitude(request.getLongitude());



        double destinationLat = 13.0827;
        double destinationLon = 80.2707;
        double distance= DistanceUtil.calculateDistance(
                request.getLatitude(),
                request.getLongitude(),
                destinationLat,
                destinationLon
        );


        busRepository.save(bus);
        return mapToResponse(bus);


    }

    private BusResponse mapToResponse(Bus bus) {
        return BusResponse.builder()
                .id(bus.getId())
                .busnumber(bus.getBusnumber())
                .latitude(bus.getLatitude())
                .longitude(bus.getLongitude())
                .eta(bus.getEta())
                .build();
    }

    }




