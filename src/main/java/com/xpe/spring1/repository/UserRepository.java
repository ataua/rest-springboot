package com.xpe.spring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xpe.spring1.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
