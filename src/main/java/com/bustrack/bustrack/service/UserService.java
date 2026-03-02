package com.bustrack.bustrack.service;

import com.bustrack.bustrack.dto.BusResponse;
import com.bustrack.bustrack.dto.UserRequest;
import com.bustrack.bustrack.dto.UserResponse;
import com.bustrack.bustrack.entity.User;

public interface UserService {
    UserResponse createUser(UserRequest request);
  //  BusResponse getUseBusLocation(Long userId);
    UserResponse loginUser(String email, String password);

}
