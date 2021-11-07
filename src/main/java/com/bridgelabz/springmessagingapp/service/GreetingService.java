package com.bridgelabz.springmessagingapp.service;

import com.bridgelabz.springmessagingapp.implementation.IGreetingService;
import com.bridgelabz.springmessagingapp.model.Greeting;
import com.bridgelabz.springmessagingapp.model.User;
import com.bridgelabz.springmessagingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Optional<Greeting> getGreetingById(long id) {
        return greetingRepository.findById(id);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting updateGreeting(long id, User user) {
        return greetingRepository.save(new Greeting(id, user.toString()));
    }
}
