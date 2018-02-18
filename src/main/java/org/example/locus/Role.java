package org.example.locus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Role {

    private String roleIdentifier;

    private String name;
    private Map<Resource,List<ActionType>> resource = new HashMap<>();



    public Role() {
    }


    public String getRoleIdentifier() {
        return roleIdentifier;
    }

    public void setRoleIdentifier(String roleIdentifier) {
        this.roleIdentifier = roleIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleIdentifier='" + roleIdentifier + '\'' +
                ", name='" + name + '\'' +
                ", resource=" + resource +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Role)
            return this.getRoleIdentifier().equals(((Role) obj).getRoleIdentifier());
        return false;
    }

    public Role(String roleIdentifier, String name, Map<Resource, List<ActionType>> resource) {
        this.roleIdentifier = roleIdentifier;
        this.name = name;
        this.resource = resource;
    }

    public Map<Resource, List<ActionType>> getResource() {
        return resource;
    }

    public void setResource(Map<Resource, List<ActionType>> resource) {
        this.resource = resource;
    }

    public Role(String roleIdentifier) {
        this.roleIdentifier = roleIdentifier;
    }
}
