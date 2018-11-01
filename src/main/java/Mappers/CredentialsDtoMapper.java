package Mappers;

import org.mapstruct.Mapper;

import DTOs.CredentialsDto;
import Entities.User;

@Mapper(componentModel = "spring")
public interface CredentialsDtoMapper {

    //Map User to CredentialsDto
	User dtoToUser(CredentialsDto dto);
	CredentialsDto userToDto(User user);
	
}
