package com.mumapp.mumapp.music;

import com.mumapp.mumapp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<User, Long> {

}