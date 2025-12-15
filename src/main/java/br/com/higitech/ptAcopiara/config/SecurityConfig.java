package br.com.higitech.ptAcopiara.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Para páginas estáticas + fetch do front, CSRF pode atrapalhar POST.
        // Como você usa fetch sem token CSRF no admin (POST/DELETE), desabilitar evita 403.
        // Se quiser CSRF depois, dá para evoluir com CookieCsrfTokenRepository.
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth -> auth
            // Público (site)
        		.requestMatchers(
        			    "/", "/index.html", "/login", "/login.html",
        			    "/css/**", "/js/**", "/images/**", "/uploads/**", "/loyaut/**",
        			    "/favicon.ico"
        			).permitAll()

            // APIs públicas (somente leitura)
            .requestMatchers(HttpMethod.GET, "/api/**").permitAll()

            // Escrita nas APIs exige ADMIN
            .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN")
            .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")

            // Admin (página)
            .requestMatchers("/admin.html", "/admin").hasRole("ADMIN")

            // Qualquer outra rota: público (ou ajuste conforme sua necessidade)
            .anyRequest().permitAll()
        );

        http.formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/admin.html", true)
            .failureUrl("/login?error")
            .permitAll()
        );

        http.logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        );

        http.httpBasic(Customizer.withDefaults()); // opcional (útil para testes via Postman)

        return http.build();
    }
}
