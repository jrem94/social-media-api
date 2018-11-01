package Mappers;

import org.mapstruct.Mapper;

import Entities.User;
import RequestDtos.ProfileCredentialsDto;

@Mapper(componentModel = "spring")
public interface ProfileCredentialsDtoMapper {
	
	//Map User to ProfileCredentialsDto
	User dtoToUser(ProfileCredentialsDto dto);
	ProfileCredentialsDto userToDto(User user);

}
