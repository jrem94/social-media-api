package com.cooksys.ftd.springboot.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.ftd.springboot.Entities.User;
import com.cooksys.ftd.springboot.RequestDtos.ProfileCredentialsDto;

@Mapper(componentModel = "spring")
public interface ProfileCredentialsDtoMapper {
	
	//Map User to ProfileCredentialsDto
	User dtoToUser(ProfileCredentialsDto dto);
	ProfileCredentialsDto userToDto(User user);

}
