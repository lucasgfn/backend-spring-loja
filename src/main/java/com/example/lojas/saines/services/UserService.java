package com.example.lojas.saines.services;

import com.example.lojas.saines.dto.UserRequestDTO;
import com.example.lojas.saines.entity.User;
import com.example.lojas.saines.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(UserRequestDTO userRequestDTO) {
        User user = new User(userRequestDTO);
        user.setPaper(user.getPaper());
        return userRepository.save(user);
    }

}
