package net.pe.yallerco.seguridad6.security;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder implements PasswordEncoder {

    public String encode(CharSequence rawPassword) {
        return String.valueOf(rawPassword.toString().hashCode());
//        String r = String.valueOf(rawPassword.toString().hashCode());
//        System.out.println(r);
//        return r;
       
    }

    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        var passwordAsString = String.valueOf(rawPassword.toString().hashCode());
        System.out.println(passwordAsString);
        return encodedPassword.equals(passwordAsString);
    }
}
