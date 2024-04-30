package com.university.elecitvecoursesappmanagement.service.implementation;

import com.university.elecitvecoursesappmanagement.entity.User;
import com.university.elecitvecoursesappmanagement.repository.UserRepository;
import com.university.elecitvecoursesappmanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updateUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(updateUser.getName());
            userToUpdate.setUserType(updateUser.getUserType());

            return userRepository.save(userToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
