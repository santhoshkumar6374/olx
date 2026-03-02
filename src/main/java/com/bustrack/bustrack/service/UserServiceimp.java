package com.bustrack.bustrack.service;

import com.bustrack.bustrack.dto.BusResponse;
import com.bustrack.bustrack.dto.UserRequest;
import com.bustrack.bustrack.dto.UserResponse;
import com.bustrack.bustrack.entity.Bus;
import com.bustrack.bustrack.entity.User;
import com.bustrack.bustrack.repository.BusRepository;
import com.bustrack.bustrack.repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceimp implements UserService{

    private final UserRepository  userRepository;
    private final BusRepository busRepository;

    public UserServiceimp(UserRepository userRepository, BusRepository busRepository) {
        this.userRepository = userRepository;
        this.busRepository = busRepository;
    }
    public UserResponse loginUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );


    }

    @Override
    public UserResponse createUser(UserRequest request) {
      //  Bus bus=busRepository.findById(request.getBusId()).orElseThrow(()->new RuntimeException("Bus not found"));

        User user=User.builder().name(request.getName()).email(request.getEmail()).role(request.getRole()).password(request.getPassword()).build();
        userRepository.save(user);
        return UserResponse.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).role(user.getRole()).build();

    }
 /*   @Override
    public BusResponse getUseBusLocation(Long userid) {
        User user=userRepository.findById(userid).orElseThrow(()->new RuntimeException("User not found"));

        Bus bus=user.getBus();
        if(bus==null){
            throw new RuntimeException("Bus not found");
        }
        return BusResponse.builder().id(bus.getId()).latitude(bus.getLatitude()).longitude(bus.getLongitude()).eta(bus.getEta()).build();



    }*/

}
