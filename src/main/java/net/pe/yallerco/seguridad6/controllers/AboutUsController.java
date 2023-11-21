package net.pe.yallerco.seguridad6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/about_us")
public class AboutUsController {

	//localhost:8020/about_us
    @GetMapping
    public Map<String, String> about() {
        //... business logic
        return Collections.singletonMap("msj", "about");
    }
}
