package com.neff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    @GetMapping(value = {"/login"})
    public String getLoginScreen() {

        return "login";
    }
}
