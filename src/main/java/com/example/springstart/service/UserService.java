package com.example.springstart.service;

import com.example.springstart.model.User;
import com.example.springstart.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        return userRepository.getOne(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public  User saveUser(User user){
        return userRepository.save(user);
    }

    public void delitById(Long id){
        userRepository.deleteById(id);
    }
}
