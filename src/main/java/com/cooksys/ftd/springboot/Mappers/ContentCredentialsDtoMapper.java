package com.cooksys.ftd.springboot.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.ftd.springboot.Entities.Tweet;
import com.cooksys.ftd.springboot.RequestDtos.ContentCredentialsDto;

@Mapper(componentModel = "spring")
public interface ContentCredentialsDtoMapper {

	Tweet dtoToTweet(ContentCredentialsDto dto);

	ContentCredentialsDto tweetToDto(Tweet tweet);
}
