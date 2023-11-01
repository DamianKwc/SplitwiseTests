package com.splitwiseapp.repository;

import com.splitwiseapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository <UserEntity, Integer> {

    UserEntity findByUsername(String username);
}
