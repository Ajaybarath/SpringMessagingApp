package com.bridgelabz.springmessagingapp.controller;

import com.bridgelabz.springmessagingapp.implementation.IGreetingService;
import com.bridgelabz.springmessagingapp.model.Greeting;
import com.bridgelabz.springmessagingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    IGreetingService greetingService;

    @GetMapping("/")
    public Greeting greeting(@RequestParam (value = "firstName", defaultValue = "World") String firstName, @RequestParam (value = "lastName", defaultValue = "World") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/get/{id}")
    public Optional<Greeting> getGreeting(@PathVariable("id") long id) {
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/get/all")
    public List<Greeting> getAllGreeting() {
        return greetingService.getAllGreetings();
    }
}
