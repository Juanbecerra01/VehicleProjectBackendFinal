package com.vehicle.vehicle.config;

import com.vehicle.vehicle.security.AuthenticationTokenFilter;
import com.vehicle.vehicle.security.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetailsService;
    @Autowired private JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired private AuthenticationTokenFilter authenticationTokenFilter;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(this.authenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

//        httpSecurity.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000);
    }
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Collections.unmodifiableList(Arrays.asList("*")));
//        configuration.setAllowedMethods(Collections.unmodifiableList(Arrays.asList("HEAD",
//                "GET", "POST", "PUT", "DELETE", "PATCH")));
//        // setAllowCredentials(true) is important, otherwise:
//        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
//        configuration.setAllowCredentials(true);
//        // setAllowedHeaders is important! Without it, OPTIONS preflight request
//        // will fail with 403 Invalid CORS request
//        configuration.setAllowedHeaders(Collections.unmodifiableList(Arrays.asList("Authorization", "Cache-Control", "Content-Type")));
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
