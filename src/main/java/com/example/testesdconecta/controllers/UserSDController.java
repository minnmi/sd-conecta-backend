package com.example.testesdconecta.controllers;

import com.example.testesdconecta.controllers.dtos.CreateUser;
import com.example.testesdconecta.controllers.dtos.UpdateUser;
import com.example.testesdconecta.controllers.dtos.UserQueryParameter;
import com.example.testesdconecta.models.UserSD;
import com.example.testesdconecta.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserSDController {

    private final UserService userService;

    @PostMapping("/create")
    private ResponseEntity<UserSD> createUser(@RequestBody CreateUser createUser) {
        final var user = this.userService.save(createUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    private ResponseEntity<UserSD> updateUser(@RequestBody UpdateUser updateUser, @PathVariable Integer userId) {
        final var user = this.userService.save(userId, updateUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/list")
    private ResponseEntity<List<UserSD>> getAll(UserQueryParameter queryParameter) {
        final var users = this.userService.findAll(queryParameter);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    private ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
      userService.deleteUserById(userId);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{userId}")
    private ResponseEntity<UserSD> findUserById(@PathVariable Integer userId) {
        final var user = this.userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
