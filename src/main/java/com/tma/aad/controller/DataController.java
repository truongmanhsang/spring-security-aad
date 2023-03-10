package com.tma.aad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/data")
    public String data() {
        return "{ \"data\": \"This is the data from server\" }";
    }
}
