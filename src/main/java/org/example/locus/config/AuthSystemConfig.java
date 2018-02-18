package org.example.locus.config;

import org.example.locus.*;
import org.example.locus.BusinessApi.AccessSystem;
import org.example.locus.BusinessApi.AccessSystemImpl;
import org.example.locus.BusinessApi.AuthSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AuthSystemConfig {
    @Bean
    public AuthSystem authSystem()
    {

        /*The below part can be avoided if we have Entities mapped to a Db and fetch the resources,roles and actiontypes from there itself*/
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
        users.add(user2);

        roles.add(role1);
        roles.add(role);
        /* The end of code which can be persisted and fetched anytime*/

        return new AuthSystem(users,roles);
    }

    @Bean
    public AccessSystem accessSystem()
    {
        return new AccessSystemImpl();
    }
}
