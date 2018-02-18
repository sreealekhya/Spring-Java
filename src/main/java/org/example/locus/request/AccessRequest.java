package org.example.locus.request;


import org.example.locus.ActionType;
import org.example.locus.Resource;

public class AccessRequest {
    public String userName;
    public ActionType actionType;
    public Resource resource;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
