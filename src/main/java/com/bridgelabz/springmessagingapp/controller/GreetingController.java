package com.bridgelabz.springmessagingapp.controller;

import com.bridgelabz.springmessagingapp.implementation.IGreetingService;
import com.bridgelabz.springmessagingapp.model.Greeting;
import com.bridgelabz.springmessagingapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s !";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam (value = "firstName", defaultValue = "World") String firstName, @RequestParam (value = "lastName", defaultValue = "World") String lastName) {
        User user = new User(firstName, lastName);

        return new Greeting(counter.incrementAndGet(), user.toString());
    }

}
