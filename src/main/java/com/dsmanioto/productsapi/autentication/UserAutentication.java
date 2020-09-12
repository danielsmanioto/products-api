package com.dsmanioto.productsapi.autentication;

import com.dsmanioto.productsapi.exception.UserAutenticationUserDontExistExecption;
import com.dsmanioto.productsapi.model.UserApplication;
import com.dsmanioto.productsapi.repository.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserAutentication implements UserDetailsService {

    private final UserApplicationRepository userApplicationRepository;

    @Autowired
    public UserAutentication(UserApplicationRepository userApplicationRepository) {
        this.userApplicationRepository = userApplicationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserApplication> userApplication = userApplicationRepository.findByUsername(username);

        if(!userApplication.isPresent()) {
            throw new UserAutenticationUserDontExistExecption("User " + username + " dont exist");
        }

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        return new User(username, userApplication.get().getPassword(), authorityListAdmin);
    }

}
