package Mappers;

import java.util.List;

import org.mapstruct.Mapper;

import DTOs.CredentialsDto;
import DTOs.UserDto;
import Entities.User;
import RequestDtos.ProfileCredentialsDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

	//Map User to ProfileCredentialsDto
    List<ProfileCredentialsDto> userEntitiesToProfileCredentialsDtos(List<User> userEntities);
    List<User> profileCredentialsDtosToUserEntities(List<ProfileCredentialsDto> profileCredentialsDtos);
    
    //Map User to CredentialsDto
    List<CredentialsDto> userEntitiesToCredentialsDtos(List<User> userEntities);
    List<User> credentialsDtosToUserEntities(List<CredentialsDto> credentialsDtos);
	
    //Map User to UserDto
    List<UserDto> userEntitiesToUserDtos(List<User> userEntities);
    List<User> UserDtosToUserEntities(List<UserDto> UserDtos);
}
