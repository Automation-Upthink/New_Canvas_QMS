//package com.upthink.Canavas_QMS.config;////import org.springframework.beans.factory.annotation.Autowired;//import org.springframework.context.annotation.Bean;//import org.springframework.context.annotation.Configuration;//import org.springframework.security.config.Customizer;//import org.springframework.security.config.annotation.web.builders.HttpSecurity;//import org.springframework.security.core.Authentication;//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;//import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;//import org.springframework.security.oauth2.core.oidc.user.OidcUser;//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;//import org.springframework.security.web.SecurityFilterChain;//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;//import org.springframework.web.cors.CorsConfiguration;//import org.springframework.web.cors.CorsConfigurationSource;//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;////import jakarta.servlet.http.HttpServletRequest;//import jakarta.servlet.http.HttpServletResponse;//import java.io.IOException;//import java.util.*;////@Configuration//public class SecurityConfig {////    @Autowired//    JwtFilter jwtFilter;////    @Autowired//    private OAuth2AuthorizedClientService authorizedClientService;////    @Bean//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//        http//                .cors(x->x.configurationSource(corsConfigurationSource()))//                .csrf(csrf -> csrf.disable())//                .authorizeHttpRequests(authz -> authz//                        .requestMatchers("/home", "/signup", "/login", "/confirm-signup",//                                "/logout",//                                "/qm/addEssay",//                                "/qm/pushToCanvas",//                                "/qm/addCanvasEssay",//                                "/qm/presignUrl",//                                "/qm/listCredsForClient",//                                "/qm/checkExpiry")//                        .permitAll()//                        .anyRequest().authenticated()//                )//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);//        return http.build();//    }//////    @Bean//    public CorsConfigurationSource corsConfigurationSource() {//        CorsConfiguration configuration = new CorsConfiguration();//        configuration.setAllowedOrigins(List.of(////                "*",//                "http://localhost:5173",//                "https://qms.upthink.com",//                "https://main.d2xuveirwkpf26.amplifyapp.com"//        )); // Allow frontend origin http://localhost:5173//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow methods//        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type")); // Allow necessary headers////        configuration.setAllowCredentials(true); // Allow credentials (cookies, headers)////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();//        source.registerCorsConfiguration("/**", configuration); // Apply CORS to all endpoints//        return source;//    }////////////}