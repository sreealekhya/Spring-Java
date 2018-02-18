package org.example.locus.BusinessApi;

import org.example.locus.ActionType;
import org.example.locus.Resource;
import org.example.locus.User;

public interface AccessSystem {
    public Boolean accessCheck(User u, ActionType a, Resource r);
}


