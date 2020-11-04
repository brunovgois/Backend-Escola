package com.escola.escola.service.mapper;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.model.Mentor;

public class MentorMapper {
    public static Mentor toMentor(MentorDTO mentorDTO) {
        Mentor mentor = new Mentor();

        mentor.setId(mentorDTO.getId());
        mentor.setName(mentorDTO.getName());
        mentor.setActive(mentorDTO.getActive());
        mentor.setCity(mentorDTO.getCity());

        return mentor;
    }

    public static MentorDTO toMentorDTO(Mentor mentor) {
        MentorDTO mentorDTO = new MentorDTO();

        mentorDTO.setId(mentor.getId());
        mentorDTO.setName(mentor.getName());
        mentorDTO.setActive(mentor.getActive());
        mentorDTO.setCity(mentor.getCity());

        return mentorDTO;
    }
}
