package org.example.locus.BusinessApi;

import org.example.locus.ActionType;
import org.example.locus.Resource;
import org.example.locus.Role;
import org.example.locus.User;

import java.util.List;
import java.util.Map;

public class AccessSystemImpl implements AccessSystem {
    @Override
    public Boolean accessCheck(User u, ActionType a, Resource r) {
        List<Role> roles = u.getRoles();
        for(Role role:roles)
        {
            Map<Resource, List<ActionType>> resources = role.getResource();

            if(resources.containsKey(r))
            {
                List<ActionType> actionTypes = resources.get(r);
                if(actionTypes.contains(a))
                    return true;
            }

        }
        return false;
    }
}
