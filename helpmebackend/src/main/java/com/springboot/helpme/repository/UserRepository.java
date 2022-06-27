package com.springboot.helpme.repository;

import com.springboot.helpme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.username=?1")
    User findByUsername(String username);
    @Transactional
    @Modifying
    @Query("update User u set u.publishing=:publishing where u.id=:id")
    void updatePublishing(@Param("publishing")Integer publishing, @Param("id")Integer id);
    @Transactional
    @Modifying
    @Query("update User u set u.receiving=:receiving where u.id=:id")
    void updateReceiving(@Param("receiving")Integer receiving, @Param("id")Integer id);
    @Transactional
    @Modifying
    @Query("update User u set u.published=:published where u.id=:id")
    void updatePublished(@Param("published")Integer published, @Param("id")Integer id);
    @Transactional
    @Modifying
    @Query("update User u set u.solved=:solved where u.id=:id")
    void updateSolved(@Param("solved")Integer solved, @Param("id")Integer id);
}
