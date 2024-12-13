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
		List<UserDetails> users = List.of(User.withUsername("client").password("{noop}12345").roles("USER").build(),
				User.withUsername("admin").password("{noop}123456").roles("ADMIN").build());
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(cus -> cus.disable()).authorizeHttpRequests(auth -> auth

				// Permitir acceso a Swagger
				.requestMatchers("/swagger-ui/", "/v3/api-docs/", "/swagger-resources/", "/webjars/").permitAll()

				// Rutas para Boletas
				.requestMatchers(HttpMethod.POST, "/boletas").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/boletas").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/boletas").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/boletas/{id}").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/boletas/{id}").hasRole("ADMIN")

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
				.requestMatchers(HttpMethod.POST, "/pelicula-sav").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/pelicula-all").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.GET, "/pelicula-id").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.PUT, "/pelicula-up").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/pelicula/{id}").hasRole("ADMIN")

				// Rutas para GeneroPelicula
				.requestMatchers(HttpMethod.POST, "/Generopelicula").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/Generopelicula").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.GET, "/Generopelicula/{id}").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.PUT, "/Generopelicula").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/Generopelicula/{id}").hasRole("ADMIN")

				// Rutas para TipoBoleta
				.requestMatchers(HttpMethod.POST, "/tipoBoleta-add").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/tipoBoleta-all").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.GET, "/tipoBoleta-id").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.PUT, "/tipoBoleta-update").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/tipoBoleta-delete").hasRole("ADMIN")

				// Rutas para Factura
				.requestMatchers(HttpMethod.POST, "/facturas").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/facturas").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.GET, "/facturas/{id}").hasAnyRole("USER", "ADMIN")
				.requestMatchers(HttpMethod.PUT, "/facturas").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/facturas/{id}").hasRole("ADMIN").anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).formLogin(login -> login.permitAll());
		return http.build();
	}
}// Fin de la clase SecurityConfig