package org.example.locus.BusinessApi;


import org.example.locus.Role;
import org.example.locus.User;

import java.util.ArrayList;
import java.util.List;

public class AuthSystem {

    private List<User> users = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    public AuthSystem(List<User> users, List<Role> roles) {
        this.users = users;
        this.roles = roles;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public boolean addRole(User u, Role r)
    {
        if(!u.getRoles().contains(r)) {
            u.getRoles().add(r);
            return true;
        }
        return false;
    }

    public boolean deleteRole(User u,Role r)
    {
        if(u.getRoles().contains(r)) {
            u.getRoles().remove(r);
            return true;
        }
        return false;
    }
}
