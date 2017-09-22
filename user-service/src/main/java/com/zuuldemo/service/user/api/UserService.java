package com.zuuldemo.service.user.api;

import com.zuuldemo.service.user.api.model.User;
import com.zuuldemo.service.user.repository.UserRepository;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/{id}")
    public User get(@PathVariable("id") long id) throws Exception {
        Logger.getLogger(getClass().getSimpleName()).info("GetUser");
        Optional<User> user = userRepository.get(id);
        return user.orElseThrow(() -> new Exception("User not found!"));
    }
}
