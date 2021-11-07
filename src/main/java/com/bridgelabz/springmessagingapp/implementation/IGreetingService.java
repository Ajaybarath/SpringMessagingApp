package com.bridgelabz.springmessagingapp.implementation;

import com.bridgelabz.springmessagingapp.model.Greeting;
import com.bridgelabz.springmessagingapp.model.User;

public interface IGreetingService {

    Greeting addGreeting(User user);
    Greeting getGreetingById();
}
