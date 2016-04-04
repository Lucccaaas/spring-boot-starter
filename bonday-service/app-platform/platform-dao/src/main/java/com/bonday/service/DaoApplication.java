package com.bonday.service;

import com.bonday.service.domain.User;
import com.bonday.service.security.token.TokenService;
import com.bonday.service.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * Created by yunge on 16/3/31.
 */
@SpringBootApplication
public class DaoApplication {

    @Resource
    private UserRepository repository;

    @Resource
    TokenService tokenService;

    public static void main(String[] args) {
        SpringApplication.run(DaoApplication.class, args);
    }

    public void run(String... args) throws Exception {

        repository.deleteAll();

        Optional<User> user0 = repository.id("");

        // save a couple of customers
        repository.save(new User("Alice", "Smith"));
        repository.save(new User("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        repository.findAll().forEach(System.out::println);
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        repository.findByLastName("Smith").forEach(System.out::println);
    }
}
