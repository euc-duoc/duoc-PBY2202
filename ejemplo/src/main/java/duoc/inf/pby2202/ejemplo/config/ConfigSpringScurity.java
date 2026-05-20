package duoc.inf.pby2202.ejemplo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSpringScurity {
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(
                auth -> auth
                    .requestMatchers(HttpMethod.GET, "api/vehiculos").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(withDefaults())
            .build();
    }
}
