package com.cooksys.ftd.springboot.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.ftd.springboot.DTOs.UserDto;
import com.cooksys.ftd.springboot.Entities.User;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {
	
	User dtoToUser(UserDto dto);
	UserDto userToDto(User user);
}
