package io.pivotal.rye.controllers;

import io.pivotal.rye.data.Who;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RyeWhoController {

    @Autowired
    Who w;

    @RequestMapping("/who")
    public String index() {
        return w.getStatus();
    }
}
