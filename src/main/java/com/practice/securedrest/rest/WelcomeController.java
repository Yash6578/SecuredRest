package com.practice.securedrest.rest;

import com.practice.securedrest.entity.User;
import com.practice.securedrest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/welcome")
    String welcome() {
        String msg = "Welcome to my API";
        User user = userRepo.findByUserName("demo");
        System.out.println(user);

        String encoded = bCryptPasswordEncoder.encode("yash");
        System.out.println(encoded);
        return msg;
    }

    @GetMapping("/password/encode/{passwd}")
    String getEncodedPassword(@PathVariable String passwd) {
        return "For password " + passwd + " encryption is " + bCryptPasswordEncoder.encode(passwd);
    }
}
