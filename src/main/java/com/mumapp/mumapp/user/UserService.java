package com.mumapp.mumapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteUserMusic(id);
        userRepository.deleteUserCity(id);
        userRepository.deleteUserRole(id);
        userRepository.deleteById(id);
    }
}
