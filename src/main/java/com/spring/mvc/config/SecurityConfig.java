/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/** 
 * Flight model class representing a flight entity.
 * - passwordEncoder: Bean for encoding passwords using BCrypt
 * - securityFilterChain: Configures HTTP security, including authorization rules,
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(
		auth -> auth.requestMatchers("/", "/register", "/login", "/css/**", "/js/**", "/images/**").permitAll()
			.anyRequest().authenticated())
		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login")
			.defaultSuccessUrl("/flights", true).permitAll())
		.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll())
		.csrf(csrf -> csrf.disable()); // For simplicity in development

	return http.build();
    }
}