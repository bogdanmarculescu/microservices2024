package org.cards.ongoinground.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/actuator/health").permitAll()
                        .requestMatchers("/ongoing").permitAll()
                        .requestMatchers("/ongoing/**").hasRole("USER")
                        .anyRequest().authenticated()
        )
                .oauth2ResourceServer(oauth2 -> oauth2
                                .jwt(Customizer.withDefaults())
                        );
        return http.build();

    }
}
