package com.vehicle.vehicle.domain;

import com.vehicle.vehicle.security.model.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -3070691131076088869L;
    private User user;
    private String token;

    public UserDTO(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
