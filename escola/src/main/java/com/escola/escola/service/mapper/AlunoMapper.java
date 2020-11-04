package com.escola.escola.service.mapper;

import com.escola.escola.dto.AlunoDTO;
import com.escola.escola.model.Aluno;


public class AlunoMapper {

    public static Aluno toAluno(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        aluno.setId(alunoDTO.getId());
        aluno.setName(alunoDTO.getName());
        aluno.setClasse(alunoDTO.getClasse());
        aluno.setActive(alunoDTO.getActive());

        return aluno;
    }

    public static AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setName(aluno.getName());
        alunoDTO.setId(aluno.getId());
        alunoDTO.setClasse(aluno.getClasse());
        alunoDTO.setActive(aluno.getActive());

        return alunoDTO;
    }
}
