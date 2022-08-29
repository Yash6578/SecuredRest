package com.practice.securedrest.rest;

import com.practice.securedrest.model.AuthenticationRequest;
import com.practice.securedrest.model.AuthenticationResponse;
import com.practice.securedrest.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/home")
    String home() {
        return "Welcome to Yash Bank";
    }

    @PostMapping("/get/token")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        String token = authenticationService.authenticate(authenticationRequest);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @GetMapping("/balance")
    String getBalance() {
        return authenticationService.getUserName() + " Your account balance is 14533 INR";
    }

    @GetMapping("/loan")
    String getLoan() {
        return "Your remaining loan amount is 450000 INR";
    }

    @GetMapping("/statement")
    String getStatement() {
        return "Server down try again later";
    }

    @GetMapping("/contact")
    String contact() {
        return "Thank you for visiting our website, we will get back to you soon.";
    }
}
