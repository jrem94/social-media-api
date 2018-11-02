package com.cooksys.ftd.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.springboot.Entities.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer>{

}
