package Mappers;

import org.mapstruct.Mapper;

import DTOs.UserDto;
import Entities.User;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
	
    //Map User to UserDto
	User dtoToUser(UserDto dto);
	UserDto userToDto(User user);
}
