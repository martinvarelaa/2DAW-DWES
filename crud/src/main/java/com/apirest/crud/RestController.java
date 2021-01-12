package com.apirest.crud;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {

    //HashMap: Conjunto de pares clave valor. Se utiliza concurrente para casos reales con el fin de guardar la integridad de los datos

    private HashMap<Integer, User> userMap = new HashMap<Integer, User>();

    private int userID = 0;

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    public User newUser(@RequestBody User user) {
        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword(), userID);
        newUser.setId(userID);
        userID++;
        userMap.put(newUser.getId(), newUser);
        return newUser;
    }

    @RequestMapping(value = "/get/", method = RequestMethod.GET)
    public HashMap<Integer, User> getUserList() {
        return this.userMap;
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.PUT)
    public User modifyUser(@RequestBody User user, @PathVariable int id) {
        User userToModify = userMap.get(id);

        userToModify.setUsername(user.getUsername());
        userToModify.setEmail(user.getEmail());
        userToModify.setPassword(user.getPassword());

        return userToModify;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable int id) {
        User deletedUser = userMap.get(id);
        userMap.remove(id);
        return deletedUser;

    }
}
