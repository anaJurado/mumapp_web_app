package com.mumapp.mumapp.user;

import com.mumapp.mumapp.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    User findById(long id);
    User findByName(String name);

}
