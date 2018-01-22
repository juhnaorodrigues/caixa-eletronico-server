package com.governo.secretaria.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by Juhnao on 1/11/18.
 */
public class JwtUserDetails implements UserDetails {

    private String login;
    private long id;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;


    public JwtUserDetails(long id, String login, String token, List<GrantedAuthority> grantedAuthorities) {

        this.login = login;
        this.id = id;
        this.token= token;
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getLogin() {
        return login;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

}
