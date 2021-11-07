package com.bridgelabz.springmessagingapp.repository;

import com.bridgelabz.springmessagingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
