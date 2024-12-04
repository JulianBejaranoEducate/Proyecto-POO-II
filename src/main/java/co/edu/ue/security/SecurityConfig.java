package co.edu.ue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userManager() {
        List<UserDetails> users = List.of(
                User.withUsername("client").password("{noop}12345").roles("USER").build(),
                User.withUsername("admin").password("{noop}123456").roles("ADMIN").build()
        );
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        HttpBasicConfigurer<HttpSecurity> httpBasic = http.csrf(cus -> cus.disable())
                .authorizeHttpRequests(aut -> aut
                        // Rutas para Usuarios
                        .requestMatchers(HttpMethod.POST, "usuario-sav").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "usuario-all").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "usuario-id\"").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "usuario-up").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "usuario-baja").hasRole("ADMIN")

                        // Rutas para Funciones
                        .requestMatchers(HttpMethod.POST, "/funciones/crear").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/funciones/todas").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/funciones/{id}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/funciones/actualizar/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/funciones/eliminar/{id}").hasRole("ADMIN")
                )
                .httpBasic();
        return http.build();
    }
}
