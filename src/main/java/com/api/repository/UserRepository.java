package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByuser(int id);

}
