package com.escola.escola.dto.mapper.decorator;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.dto.mapper.MentorMapper;
import com.escola.escola.model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MentorMapperDecorator implements MentorMapper {

    @Autowired
    @Qualifier("delegate")
    private MentorMapper delegate;

    @Override
    public Mentor toMentor(MentorDTO mentorDTO) {
        return delegate.toMentor(mentorDTO);
    }

    @Override
    public MentorDTO toMentorDTO(Mentor mentor) {
        return delegate.toMentorDTO(mentor);
    }
}
