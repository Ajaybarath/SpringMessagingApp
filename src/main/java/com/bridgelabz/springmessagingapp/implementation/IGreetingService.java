package com.bridgelabz.springmessagingapp.implementation;

import com.bridgelabz.springmessagingapp.model.Greeting;
import com.bridgelabz.springmessagingapp.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {

    Greeting addGreeting(User user);
    Optional<Greeting> getGreetingById(long id);
    List<Greeting> getAllGreetings();
}
