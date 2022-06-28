package com.j2ee.j2eetdspring.services;

import com.j2ee.j2eetdspring.entities.User;
import com.j2ee.j2eetdspring.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdate(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String username) {
        return userRepository.findById(username).orElse(null);
    }

}
