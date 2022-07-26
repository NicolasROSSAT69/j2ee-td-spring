package com.j2ee.j2eetdspring.controllers;

import com.j2ee.j2eetdspring.entities.User;
import com.j2ee.j2eetdspring.exceptions.ResourceNotFoundException;
import com.j2ee.j2eetdspring.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Récupération d'un utilisateur à partir de son identifiant" )
    @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé" )
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {

        return userService.getUserById(id);

    }

    @Operation(summary = "Ajout d'un utilisateur" )
    @RequestMapping(method = RequestMethod.PUT)
    public User createOrUpdate(@RequestBody @Valid User user) {

        return userService.createOrUpdate(user);

    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<User> getAllUsers() {

        return userService.getAllUsers();

    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") Long id) {

        userService.deleteUser(id);

    }

    @RequestMapping(method = RequestMethod.GET) public Page<User> getUsers(Pageable pageable) {

        return userService.getUsersWithPaging(pageable);

    }

    @Operation(summary = "Mise à jour du mot de passe d'un utilisateur")
    @RequestMapping(path = "/update-password", method = RequestMethod.GET)
    public void setPassword(@RequestParam (value = "username") String userName, @RequestParam(value = "password") String newPassword) throws IllegalAccessException {

        userService.setPassword(userName, newPassword);

    }

}
