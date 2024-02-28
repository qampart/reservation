package com.system.reservation.user.controller;

import com.system.reservation.user.model.User;
import com.system.reservation.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

     // nie robie tu Optionala bo przy usuwaniu zawsze sie robi voida, bo vez sensu aby przy pomyslnej próbie usunięcia zwracac np użytkownika
    // usuwanie - typ zwrotny void + reguły sprawdzajace istnienie
}
