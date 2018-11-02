package com.cooksys.ftd.springboot.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.ftd.springboot.DTOs.CredentialsDto;
import com.cooksys.ftd.springboot.Entities.Credentials;

@Mapper(componentModel = "spring")
public interface CredentialsMapper {

	Credentials dtoToCredentials(CredentialsDto dto);
	CredentialsDto cedentialsToDto(Credentials credentials);
	
}
