package com.mumapp.mumapp.user;

import com.mumapp.mumapp.music.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteUserMusic(id);
        userRepository.deleteUserCity(id);
        userRepository.deleteUserRole(id);
        userRepository.deleteById(id);
    }
}
