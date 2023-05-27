package com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.controller;

import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.model.User;
import com.samhcoco.projects.springbootkubernetesmysqlmongodbkeycloak.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final String VERSION = "api/v1";

    private final UserService userService;

    @GetMapping(VERSION + "/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        val user = userService.getById(id);
        if (nonNull(user)) {
            return new ResponseEntity<>(user, OK);
        }
        return new ResponseEntity<>("User not found.", NOT_FOUND);
    }

    @PostMapping(VERSION + "/user")
    public ResponseEntity<Object> save(@RequestBody User user) {
        val created = userService.create(user);
        if (nonNull(created)) {
            return new ResponseEntity<>(created, CREATED);
        }
        return new ResponseEntity<>("User already exists.", BAD_REQUEST);
    }

    @PutMapping(VERSION + "/user")
    public ResponseEntity<Object> update(@RequestBody User user) {
        val updated = userService.update(user);
        if (nonNull(updated)) {
            return new ResponseEntity<>(updated, OK);
        }
        return new ResponseEntity<>("User does not exist.", BAD_REQUEST);
    }

    @DeleteMapping(VERSION + "/user/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(OK);
    }

    @GetMapping(VERSION + "/user/list-all")
    public ResponseEntity<Object> listAllUsers() {
        return new ResponseEntity<>(userService.listAll(), OK);
    }

}
