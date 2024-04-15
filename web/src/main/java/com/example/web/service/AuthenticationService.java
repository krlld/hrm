package com.example.web.service;

import com.example.web.dto.AuthenticationRequest;
import com.example.web.dto.AuthenticationResponse;
import com.example.web.dto.RefreshRequest;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    AuthenticationResponse refresh(RefreshRequest refreshRequest);
}
