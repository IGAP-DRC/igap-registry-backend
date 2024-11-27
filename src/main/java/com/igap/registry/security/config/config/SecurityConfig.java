package com.igap.registry.security.config.config;


import com.igap.registry.security.config.facade.SecurityConfigFacade;
import com.igap.registry.security.cors.CustomCorsConfiguration;
import com.igap.registry.security.jwt.filter.filter.CustomAuthenticationFilter;
import com.igap.registry.security.jwt.handler.CustomAccessDeniedHandler;
import com.igap.registry.security.jwt.handler.CustomAuthenticationEntryPoint;
import com.igap.registry.security.jwt.handler.CustomAuthenticationFailureHandler;
import com.igap.registry.security.provider.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * class SecurityConfig
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 IGAP
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomCorsConfiguration customCorsConfiguration;

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }

    @Bean
    public AccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    private final SecurityConfigFacade facade;

    public SecurityConfig(SecurityConfigFacade facade) {
        this.facade = facade;

    }

    private static final String[] POS_AUTH_WHITELIST = {};

    private static final String[] GET_AUTH_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/actuator/**",
            "/api/v1/accounts/**",
            "/api/v1/accounts/activation/**"
    };


    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider(facade.getLoadUserByUsernameService(), passwordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception.
                        authenticationEntryPoint(customAuthenticationEntryPoint()).
                        accessDeniedHandler(customAccessDeniedHandler()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, GET_AUTH_WHITELIST).permitAll()
                        .requestMatchers(HttpMethod.POST, POS_AUTH_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                )
                .cors(c -> c.configurationSource(customCorsConfiguration))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(new CustomAuthenticationFilter(customAuthenticationFailureHandler()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(facade.getAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();

    }

}
