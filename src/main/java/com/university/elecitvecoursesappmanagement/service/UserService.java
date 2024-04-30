package com.university.elecitvecoursesappmanagement.service;

import com.university.elecitvecoursesappmanagement.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User addUser(User user);

    User updateUser(Long id, User updateUser);

    void deleteUserById(Long id);

    void deleteAllUsers();
}
