package com.cooksys.ftd.springboot.Mappers;

import org.mapstruct.Mapper;

import com.cooksys.ftd.springboot.DTOs.ContextDto;
import com.cooksys.ftd.springboot.Entities.Context;

@Mapper
public interface ContextMapper {

	Context contextDtoToContext(ContextDto contextDto);

	ContextDto contextToContextDto(Context context);

}
