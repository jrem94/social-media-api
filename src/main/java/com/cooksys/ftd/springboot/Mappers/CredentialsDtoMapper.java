package com.cooksys.ftd.springboot.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.ftd.springboot.DTOs.CredentialsDto;
import com.cooksys.ftd.springboot.Entities.User;

@Mapper(componentModel = "spring")
public interface CredentialsDtoMapper {

	User dtoToUser(CredentialsDto dto);
	CredentialsDto userToDto(User user);
	
}
