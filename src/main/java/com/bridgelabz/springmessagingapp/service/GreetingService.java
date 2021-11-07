package com.bridgelabz.springmessagingapp.service;

import com.bridgelabz.springmessagingapp.implementation.IGreetingService;
import com.bridgelabz.springmessagingapp.model.Greeting;
import com.bridgelabz.springmessagingapp.model.User;
import com.bridgelabz.springmessagingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello %s !";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), user.toString()));
    }

    @Override
    public Greeting getGreetingById() {
        return null;
    }
}
