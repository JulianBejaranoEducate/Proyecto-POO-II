package co.edu.ue.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
        http.csrf(cus -> cus.disable())
        				// Rutas para Boletas
                .authorizeHttpRequests(aut -> aut.requestMatchers(HttpMethod.POST, "boletas-add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "boletas-all").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "boletas-update").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "boletas-id").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "boletas-delete").hasRole("ADMIN")
                		
                        // Rutas para Usuarios
                        .requestMatchers(HttpMethod.POST, "/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/usuarios/{id}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/usuarios").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/{id}").hasRole("ADMIN")

                        // Rutas para Funciones
                        .requestMatchers(HttpMethod.POST, "/funciones").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/funciones").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/funciones/{id}").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/funciones").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/funciones/{id}").hasRole("ADMIN")

                        // Rutas para Peliculas
                        .requestMatchers(HttpMethod.POST, "pelicula-sav").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "pelicula-all").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "pelicula-id").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "pelicula-up").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "pelicula-delete").hasRole("ADMIN")

                        // Rutas para GeneroPelicula
                        .requestMatchers(HttpMethod.POST, "genero-sav").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "genero-all").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "genero-id").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "genero-up").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "genero-delete").hasRole("ADMIN")
                        
                        // Rutas para TipoBoleta
                        .requestMatchers(HttpMethod.POST, "tipoBoleta-add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "tipoBoleta-all").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "tipoBoleta-id").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "tipoBoleta-update").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "tipoBoleta-delete").hasRole("ADMIN")
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
