package net.pe.yallerco.seguridad6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/welcome")
public class WelcomeController {

	//http://localhost:8020/welcome
    @GetMapping
    public Map<String, String> welcome() {
        return Collections.singletonMap("msj", "welcome");
    }
}
