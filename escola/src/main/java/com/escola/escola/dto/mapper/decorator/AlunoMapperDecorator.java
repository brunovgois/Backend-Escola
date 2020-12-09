package com.escola.escola.dto.mapper.decorator;

import com.escola.escola.dto.AlunoDTO;
import com.escola.escola.dto.mapper.AlunoMapper;
import com.escola.escola.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class AlunoMapperDecorator implements AlunoMapper {

    @Autowired
    @Qualifier("delegate")
    private AlunoMapper delegate;


    @Override
    public Aluno toAluno(AlunoDTO alunoDTO){
        return delegate.toAluno(alunoDTO);

    }

    @Override
    public AlunoDTO toAlunoDTO(Aluno aluno) {
        return delegate.toAlunoDTO(aluno);
    }
}
