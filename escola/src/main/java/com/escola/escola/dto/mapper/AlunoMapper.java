package com.escola.escola.dto.mapper;

import com.escola.escola.dto.AlunoDTO;
import com.escola.escola.dto.mapper.decorator.AlunoMapperDecorator;
import com.escola.escola.model.Aluno;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(AlunoMapperDecorator.class)
public interface AlunoMapper {
    Aluno toAluno(AlunoDTO alunoDTO);
    AlunoDTO toAlunoDTO(Aluno aluno);
}
