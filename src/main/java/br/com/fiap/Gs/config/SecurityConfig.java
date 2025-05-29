package br.com.fiap.Gs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private AuthFilter authFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/h2-console/**"
                        ).permitAll()
                        .requestMatchers(HttpMethod.POST, "/users/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/alertas/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/alertas/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/alertas/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.POST, "/rotas-seguras/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/rotas-seguras/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/rotas-seguras/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.POST, "/abrigos/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.PUT, "/abrigos/**").hasRole("ADMIN")
                        //.requestMatchers(HttpMethod.DELETE, "/abrigos/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions().disable())
                .build();
    }



    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
