package net.pe.yallerco.seguridad6.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/accounts")
public class AccountsController {

	//localhost:8020/accounts
    @GetMapping
    public Map<String, String> accounts() {
        //... business logic
        return Collections.singletonMap("msj", "accounts");
    }
}
