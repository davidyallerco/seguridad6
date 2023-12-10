package net.pe.yallerco.seguridad6.security;

import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import net.pe.yallerco.seguridad6.repositories.CustomerRepository;

@Component
@AllArgsConstructor
public class MyAuthenticationProvider implements AuthenticationProvider {

    private CustomerRepository customerRepository;//David: el autowired de constructor esta implicito, y tambien se apoya de lombok
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final var username = authentication.getName();
        final var pwd = authentication.getCredentials().toString();

        final var customerFromDb = this.customerRepository.findByEmail(username);
        final var customer = customerFromDb.orElseThrow(() -> new BadCredentialsException("Invalid credentials"));
        final var customerPwd = customer.getPassword();


        if (passwordEncoder.matches(pwd, customerPwd)) {
            final var roles = customer.getRoles();
            final var authorities = roles
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
