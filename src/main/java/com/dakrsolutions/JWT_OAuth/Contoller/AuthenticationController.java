package com.dakrsolutions.JWT_OAuth.Contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dakrsolutions.JWT_OAuth.Models.ReponseModel;
import com.dakrsolutions.JWT_OAuth.Models.RequestModel;
import com.dakrsolutions.JWT_OAuth.Service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ReponseModel createToken(@RequestBody RequestModel jwtRequest) throws Exception {
        return authenticationService.authenticate(jwtRequest);
    }
}

