package org.example.locus.controller;

import org.example.locus.BusinessApi.AuthSystem;
import org.example.locus.BusinessApi.AccessSystem;
import org.example.locus.Role;
import org.example.locus.User;
import org.example.locus.request.AccessRequest;
import org.example.locus.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleBasedSystem {

    @Autowired
    AuthSystem authSystem;

    @Autowired
    AccessSystem accessSystem;


    @RequestMapping(value = "/addUserWithRole", method = RequestMethod.PUT)
    @ResponseBody
    public String addUserWithRole(@RequestBody UserRequest request) {
        try {
            if(request.getUserName()!=null && request.getRoleIdentifier()!=null) {
                if (authSystem.getUsers().contains(new User(request.getUserName())) && authSystem.getRoles().contains(new Role(request.getRoleIdentifier()))) {
                    User user = authSystem.getUsers().get(authSystem.getUsers().indexOf(new User(request.getUserName())));
                    Role role = authSystem.getRoles().get(authSystem.getRoles().indexOf(new Role(request.getRoleIdentifier())));

                    Boolean result = authSystem.addRole(user, role);
                    if (result.booleanValue())
                        return "Success";
                    else
                        return "Role already present";
                }
            }
            else
                return "User or Role cannot be Null";
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return "User Or Role Not Found!";
    }

    @RequestMapping(value = "/deleteUserWithRole", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUserWithRole(@RequestBody UserRequest request) {
        try {
            if(request.getUserName()!=null && request.getRoleIdentifier()!=null) {
                if (authSystem.getUsers().contains(new User(request.getUserName())) && authSystem.getRoles().contains(new Role(request.getRoleIdentifier()))) {
                    User user = authSystem.getUsers().get(authSystem.getUsers().indexOf(new User(request.getUserName())));
                    Role role = authSystem.getRoles().get(authSystem.getRoles().indexOf(new Role(request.getRoleIdentifier())));

                    Boolean result = authSystem.deleteRole(user, role);
                    if (result.booleanValue())
                        return "Success";
                    else
                        return "Nothing to remove";

                }
            }
            else
                return "User or Role cannot be Null";
        }
        catch(Exception ex)
        {
            throw ex;

        }
        return "User Or Role Not Found!";
    }

    @RequestMapping(value = "/checkUserWithRole", method = RequestMethod.GET)
    @ResponseBody
    public String checkAccess(@RequestBody AccessRequest request) {
        try {

            if (authSystem.getUsers().contains(new User(request.getUserName()))) {
                User user = authSystem.getUsers().get(authSystem.getUsers().indexOf(new User(request.getUserName())));

                Boolean check = accessSystem.accessCheck(user,request.getActionType(),request.getResource());
                if(check.booleanValue())
                    return "Yes Access Present";
                else
                    return "No Access";
            }

        }
        catch(Exception ex)
        {
            throw ex;
        }
        return "User Or ActionType Or Resource Not Found!";
    }




}
