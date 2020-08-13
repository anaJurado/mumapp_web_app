package com.mumapp.mumapp.user;

import com.mumapp.mumapp.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findById(long id);

    User deleteUserById(long id);

    User findByName(String name);

    @Modifying
    @Query( value="DELETE FROM user_music WHERE user_id= ?1",
            nativeQuery=true)
    void deleteUserMusic( long id);

    @Modifying
    @Query( value="DELETE FROM user_city WHERE user_id= ?1",
            nativeQuery=true)
    void deleteUserCity( long id);

    @Modifying
    @Query( value="DELETE FROM user_roles WHERE user_id= ?1",
            nativeQuery=true)
    void deleteUserRole( long id);


}
