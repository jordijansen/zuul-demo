package com.zuuldemo.service.user.repository;

import com.zuuldemo.service.user.api.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User(1L, "jordijansen", "Jordi", "Jansen"));
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> get(final long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }
}
