//package org.apache.flink.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//@EnableWebFluxSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//            .authorizeExchange(exchanges -> exchanges
//                .pathMatchers("/graphiql", "/graphql", "/static/**").permitAll()
//                .anyExchange().authenticated()
//            )
//            .csrf(ServerHttpSecurity.CsrfSpec::disable)
//            .build();
//    }
//}