package com.cooksys.ftd.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.springboot.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	
}