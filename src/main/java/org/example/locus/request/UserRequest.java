package org.example.locus.request;


public class UserRequest {
    public String userName;
    public String roleIdentifier;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleIdentifier() {
        return roleIdentifier;
    }

    public void setRoleIdentifier(String roleIdentifier) {
        this.roleIdentifier = roleIdentifier;
    }
}
