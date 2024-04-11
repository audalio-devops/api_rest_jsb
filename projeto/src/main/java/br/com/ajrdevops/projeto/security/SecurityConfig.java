package br.com.ajrdevops.projeto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configura autenticação usando um provedor de autenticação padrão do Spring Security
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("password")
                .roles("USER");
    }

    protected void configure(HttpSecurity http) throws Exception {
        // Configura as regras de segurança HTTP
        http
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET, "/ususarios").hasRole("ADMIN")
                .anyRequest().authenticated(); // Todas as outras URLs precisam de autenticação
    }
}
