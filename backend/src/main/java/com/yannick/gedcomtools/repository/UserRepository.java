package com.yannick.gedcomtools.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yannick.gedcomtools.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
