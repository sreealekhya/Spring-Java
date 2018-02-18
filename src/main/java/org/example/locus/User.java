package org.example.locus;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class User {

    private String userName;

    private String name;

    private List<Role> roles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User() {

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
            return this.getUserName().equals(((User) obj).getUserName());
        return false;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, String name) {
        this.userName = userName;
        this.name = name;
    }
}
