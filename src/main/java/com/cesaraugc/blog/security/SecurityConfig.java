package com.cesaraugc.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.requestMatchers("/**")
                                .hasRole("USER")).httpBasic(httpBasic -> httpBasic.init(http))
                                .formLogin(formLogin -> formLogin.disable()).csrf(csrf -> csrf.disable());
                return http.build();
        }

        @Bean
        public UserDetailsService users() {
                UserDetails user = User.builder()
                                .username("user")
                                .password(encoder().encode("password"))
                                .roles("USER")
                                .build();

                UserDetails admin = User.builder()
                                .username("admin")
                                .password(encoder().encode("password"))
                                .roles("ADMIN", "USER")
                                .build();

                return new InMemoryUserDetailsManager(user, admin);
        }

        @Bean
        public PasswordEncoder encoder() {
                return new BCryptPasswordEncoder();
        }
}
