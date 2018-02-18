package org.example.locus;


import org.example.locus.*;
import org.example.locus.BusinessApi.AuthSystem;
import org.example.locus.controller.RoleBasedSystem;
import org.example.locus.request.UserRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hello {

    public static void main(String[] args)
    {

        ArrayList<ActionType> actionTypes = new ArrayList<>();
        actionTypes.add(ActionType.READ);
        Map<Resource, List<ActionType>> resourceListHashMap = new HashMap<>();
        resourceListHashMap.put(Resource.A,actionTypes);
        Role role = new Role("A_user", "A_Read_Only", resourceListHashMap);
        ArrayList<ActionType> actionTypes1 = new ArrayList<>();
        actionTypes1.add(ActionType.READ);
        Map<Resource, List<ActionType>> resourceListHashMap1 = new HashMap<>();
        resourceListHashMap1.put(Resource.B,actionTypes1);
        Role role1 = new Role("B_user", "B_Read_Only", resourceListHashMap1);

        User user1 = new User("alekhya", "Alekhya");
        User user2 = new User("apoorva", "Apoorva");

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Role> roles = new ArrayList<>();
        users.add(user1);
        roles.add(role);
        AuthSystem authSystem = new AuthSystem(users, roles);

        RoleBasedSystem syst = new RoleBasedSystem();
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName("alekhya");
        userRequest.setRoleIdentifier("A_user");
        //syst.setAuthSystem(authSystem);
        syst.addUserWithRole(userRequest);


        authSystem.addRole(user1,role);
        System.out.println(user1.getRoles());


    }

}
