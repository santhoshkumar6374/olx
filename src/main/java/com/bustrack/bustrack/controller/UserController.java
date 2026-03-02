package com.bustrack.bustrack.controller;


import com.bustrack.bustrack.dto.BusResponse;
import com.bustrack.bustrack.dto.LoginRequest;
import com.bustrack.bustrack.dto.UserRequest;
import com.bustrack.bustrack.dto.UserResponse;
import com.bustrack.bustrack.service.BusService;
import com.bustrack.bustrack.service.UserService;
import com.bustrack.bustrack.service.UserServiceimp;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BusService busService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse createUser(@RequestBody UserRequest request){
        return userService.createUser(request);
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {

        UserResponse user = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(user);
    }


    @GetMapping("/{busNumber}/buslocation")
    public BusResponse getBus(@PathVariable String  busNumber){
        return busService.getBus(busNumber);
    }






}
