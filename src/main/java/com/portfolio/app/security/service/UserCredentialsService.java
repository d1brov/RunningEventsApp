package com.portfolio.app.security.service;

import com.portfolio.app.persistence.model.Role;
import com.portfolio.app.persistence.model.UserCredentials;
import com.portfolio.app.persistence.repository.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserCredentialsService implements UserDetailsService {
    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCredentials userCredentials = userCredentialsRepository.findByUsername(username);

        if (userCredentials == null) {
            throw new UsernameNotFoundException(String.format("User with username '%s' not found", username));
        }

        return User.builder()
                .username(userCredentials.getUsername())
                .password(userCredentials.getPassword())
                .authorities(getAuthorities(userCredentials.getRoles()))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        roles.forEach(role -> {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
            role.getPermissions()
                    .forEach(permission -> grantedAuthorities
                            .add(new SimpleGrantedAuthority(permission.getName())));
        });
        return grantedAuthorities;
    }
}
