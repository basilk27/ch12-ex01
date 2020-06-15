package com.mbsystems.ch12ex01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class Ch12Ex01SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.oauth2Login();

        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        var clentRegistration = clientRegistration();

        return new InMemoryClientRegistrationRepository( clentRegistration );
    }

    private ClientRegistration clientRegistration() {
        return CommonOAuth2Provider.GITHUB
                .getBuilder( "github" )
                .clientId( "5472664eaec4dc9b8d92" )
                .clientSecret( "c4276da078df7b05450f7c6d6161da828b0aaf70" )
                .build();
    }
}
