package com.cesaraugc.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cesaraugc.blog.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public UserDetailsService userDetailsService() {
                return new UserServiceImpl();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
                return authConfig.getAuthenticationManager();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                                .requestMatchers("/users/**").hasRole("ADMIN")
                                .anyRequest().hasRole("USER"))
                                .httpBasic(httpBasic -> httpBasic.init(http))
                                .csrf(csrf -> csrf.disable())
                                .authenticationProvider(authenticationProvider());

                return http.build();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
                DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
                authProvider.setUserDetailsService(userDetailsService());
                authProvider.setPasswordEncoder(encoder());
                authProvider.setAuthoritiesMapper(authoritiesMapper());

                return authProvider;
        }

        @Bean
        public GrantedAuthoritiesMapper authoritiesMapper() {
                SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
                mapper.setPrefix("ROLE_"); // this line is not required
                mapper.setConvertToUpperCase(true); // convert your roles to uppercase
                mapper.setDefaultAuthority("USER"); // set a default role

                return mapper;
        }

        @Bean
        public PasswordEncoder encoder() {
                return new BCryptPasswordEncoder();
        }

}
