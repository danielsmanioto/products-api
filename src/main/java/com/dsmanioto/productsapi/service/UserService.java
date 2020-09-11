package com.dsmanioto.productsapi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Value("${auth.user}")
    private String username;

    @Value("${auth.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        return new User(username, password, authorityListAdmin);
    }

}
