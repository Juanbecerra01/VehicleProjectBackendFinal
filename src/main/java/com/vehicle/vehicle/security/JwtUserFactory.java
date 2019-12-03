package com.vehicle.vehicle.security;

import com.vehicle.vehicle.security.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class JwtUserFactory {

    public static JwtUser create(User user) {
        return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), user,
                mapToGrantedAuthorities(new ArrayList<>(Collections.singletonList("ROLE " + user.getRole()))), user.isEnabled());
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
