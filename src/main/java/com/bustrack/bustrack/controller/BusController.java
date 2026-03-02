package com.bustrack.bustrack.controller;

import com.bustrack.bustrack.dto.BusRequest;
import com.bustrack.bustrack.dto.BusResponse;
import com.bustrack.bustrack.dto.LocationUpdateRequest;
import com.bustrack.bustrack.entity.Bus;
import com.bustrack.bustrack.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService service;

    public BusController(BusService service) {
        this.service = service;
    }

    @PostMapping
    public BusResponse create(@RequestBody BusRequest request) {
        return service.createBus(request);
    }

    @GetMapping("/all")
    public List<Bus> getAll() {
        return  service.getAllBus();
    }

    @PutMapping("/{id}/location")
    public BusResponse updateLocation(
            @PathVariable Long id,
            @RequestBody LocationUpdateRequest request) {
        return service.updateLocation(id, request);
    }

    @GetMapping("/{busnumber}")
    public BusResponse get(@PathVariable String busnumber) {
        return service.getBus(busnumber);
    }
}
