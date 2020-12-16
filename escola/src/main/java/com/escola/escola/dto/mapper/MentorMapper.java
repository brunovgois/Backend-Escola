package com.escola.escola.dto.mapper;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.dto.mapper.decorator.MentorMapperDecorator;
import com.escola.escola.model.Mentor;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(MentorMapperDecorator.class)
public interface MentorMapper {
    Mentor toMentor(MentorDTO mentorDTO);
    MentorDTO toMentorDTO(Mentor mentor);
}
