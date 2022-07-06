package com.j2ee.j2eetdspring.services;

import com.j2ee.j2eetdspring.entities.User;
import com.j2ee.j2eetdspring.exceptions.ResourceNotFoundException;
import com.j2ee.j2eetdspring.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createOrUpdate(User user) {

        return userRepository.save(user);

    }

    public User getUserById(Long id) throws ResourceNotFoundException {

        //return userRepository.findById(username).orElse(null);
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent())
        {
            return user.get();
        }
        throw new ResourceNotFoundException(User.class, id);

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }

    public Page<User> getUsersWithPaging(Pageable pageable) {

        return userRepository.findAll(pageable);

    }
}
