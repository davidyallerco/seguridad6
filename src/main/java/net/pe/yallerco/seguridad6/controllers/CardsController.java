package net.pe.yallerco.seguridad6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/cards")
public class CardsController {

	//localhost:8020/cards
    @GetMapping
    public Map<String, String> cards() {
        //... business logic
        return Collections.singletonMap("msj", "cards");
    }
}
