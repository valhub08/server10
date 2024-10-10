package com.example.server10.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedResourceController {

    @GetMapping("/protected/resource")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("This is a protected resource.");
    }
}