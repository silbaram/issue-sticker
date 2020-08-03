package com.jin.issuesticker.user.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@ToString
public class UserDto implements UserDetails {

    @Getter @Setter
    private Long idx;

    @Id @Getter @Setter
    private String id;

    @Setter
    private String password;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private int isAccess;

    @Getter @Setter
    private List<String> roles;

    private boolean active = true;

    @Builder
    public UserDto(Long idx, String id, String password, String username, String email, int isAccess, List<String> roles) {
        this.idx = idx;
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.isAccess = isAccess;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
