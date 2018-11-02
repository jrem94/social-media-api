package com.cooksys.ftd.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.springboot.Entities.Hashtag;

public interface TagRepository extends JpaRepository <Hashtag, Integer>{

}
