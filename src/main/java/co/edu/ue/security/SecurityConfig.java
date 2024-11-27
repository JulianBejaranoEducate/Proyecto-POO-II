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
				User.withUsername("client").password("{noop}12345").roles("USERS").build(),
				User.withUsername("admin").password("{noop}123456").roles("ADMINS").build());
		return new InMemoryUserDetailsManager(users);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(cus -> cus.disable())
				.authorizeHttpRequests(aut -> aut.requestMatchers(HttpMethod.POST, "/dato-sav").hasAnyRole("ADMINS")
						//.requestMatchers(HttpMethod.POST,"/dato-sav").hasAnyRole("USERS", "ADMINS")
						.requestMatchers(HttpMethod.GET, "/dato-all").authenticated()
						.requestMatchers(HttpMethod.GET, "/dato-id").hasAnyRole("USERS")
						.requestMatchers(HttpMethod.GET, "/dato-email").hasAnyRole("USERS", "ADMINS")
						.requestMatchers(HttpMethod.PUT, "/dato-up").hasAnyRole("ADMINS")

				).httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
