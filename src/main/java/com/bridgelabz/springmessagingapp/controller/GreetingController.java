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

    @GetMapping("/put/{id}")
    public Greeting updateGreeting(@PathVariable (value = "id") long id, @RequestParam (value = "firstName") String firstName, @RequestParam (value = "lastName") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.updateGreeting(id, user);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        return "Deleted" + id + " successfully";
    }
}
