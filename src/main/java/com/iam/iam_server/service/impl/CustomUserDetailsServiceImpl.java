package com.iam.iam_server.service.impl;

import com.iam.iam_server.entity.Permission;
import com.iam.iam_server.entity.Role;
import com.iam.iam_server.entity.User;
import com.iam.iam_server.repository.UserRepository;
import com.iam.iam_server.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        System.out.println("######################################");
        System.out.println("Loading User : " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("User Not Found");
                    return new UsernameNotFoundException("User Not Found");
                });

        System.out.println("User Found : " + user.getUsername());
        System.out.println("Encoded Password : " + user.getPassword());

        Set<GrantedAuthority> authorities = new HashSet<>();

        // Add Roles
        if (user.getRoles() != null) {
            for (Role role : user.getRoles()) {

                System.out.println("ROLE -> " + role.getName());

                authorities.add(new SimpleGrantedAuthority(role.getName()));

                // Add Permissions
                if (role.getPermissions() != null) {
                    for (Permission permission : role.getPermissions()) {

                        System.out.println("PERMISSION -> " + permission.getName());

                        authorities.add(
                                new SimpleGrantedAuthority(permission.getName())
                        );
                    }
                }
            }
        }

        System.out.println("Authorities : " + authorities);
        System.out.println("#############################################");

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}