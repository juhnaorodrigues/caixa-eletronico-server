package com.governo.secretaria.security.entity;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by Juhnao on 1/11/18.
 */
public class JwtUser {
    private String login;
    private long id;
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
