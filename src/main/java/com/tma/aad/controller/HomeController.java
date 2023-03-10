package com.tma.aad.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    @PreAuthorize("@authorityValidatorService.hasAccess('nurseReview_READ')")
    public String home() {
        return "home";
    }

    @GetMapping("/403-test")
    @PreAuthorize("@authorityValidatorService.hasAccess('notfound')")
    public String unAuthorization() {
        return "home";
    }
}
