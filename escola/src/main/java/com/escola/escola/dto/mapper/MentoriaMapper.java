package com.escola.escola.dto.mapper;

import com.escola.escola.dto.MentoriaDTO;
import com.escola.escola.model.Aluno;
import com.escola.escola.model.Mentor;
import com.escola.escola.model.Mentoria;

public class MentoriaMapper {
    public static Mentoria toMentoria(MentoriaDTO mentoriaDTO){
        Mentoria mentoria = new Mentoria();
        Aluno aluno = new Aluno();
        Mentor mentor = new Mentor();

        aluno.setId(mentoriaDTO.getAlunoId());
        mentor.setId(mentoriaDTO.getMentorId());

        mentoria.setId(mentoriaDTO.getId());
        mentoria.setAluno(aluno);
        mentoria.setMentor(mentor);
        mentoria.setActive(mentoriaDTO.getActive());

        return mentoria;
    }

    public static MentoriaDTO toMentoriaDTO(Mentoria mentoria){
        MentoriaDTO mentoriaDTO = new MentoriaDTO();

        mentoriaDTO.setId(mentoria.getId());
        mentoriaDTO.setAlunoId(mentoria.getAluno().getId());
        mentoriaDTO.setMentorId(mentoria.getMentor().getId());
        mentoriaDTO.setActive(mentoria.getActive());

        return mentoriaDTO;
    }
}
