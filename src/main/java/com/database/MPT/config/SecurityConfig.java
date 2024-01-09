package com.database.MPT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
               .authorizeHttpRequests((authorize) -> authorize
                       .requestMatchers("/", "/index", "/css/**", "/js/**", "/img/**").permitAll()
                       .requestMatchers("/gownojebane").hasRole("ADMIN")
                       .anyRequest().authenticated()
               )
                .formLogin(
                        (form) -> form
                                .loginPage("/login")
                                .defaultSuccessUrl("/hello")
                                .permitAll()
                )
                .logout(
                        LogoutConfigurer::permitAll
                );

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
