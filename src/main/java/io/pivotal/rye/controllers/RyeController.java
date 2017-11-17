package io.pivotal.rye.controllers;

import io.pivotal.rye.brewing.BarrelNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class RyeController {

    private final BarrelNames barrelNames;

    @Autowired
    public RyeController(BarrelNames barrelNames) {
        this.barrelNames = barrelNames;
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("barrel", barrelNames.getActiveName());
        return "index";
    }
}
