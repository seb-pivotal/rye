package io.pivotal.rye.controllers;

import io.pivotal.rye.brewing.Barrel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RyeController {

    private final Barrel barrel;

    @Autowired
    public RyeController(Barrel barrel) {
        this.barrel = barrel;
    }

    @RequestMapping("/")
    public String index() {
        return barrel.getInscription();
    }
}
