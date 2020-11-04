package com.escola.escola.service;

import com.escola.escola.dto.AlunoDTO;
import com.escola.escola.model.Aluno;
import com.escola.escola.repository.AlunoRepository;
import com.escola.escola.service.mapper.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MentoriaService mentoriaService;

    public List<Aluno> getAlunosAtivos() {
        return alunoRepository.findByActive(1);
    }

    public List<Aluno> getAlunosInativos() {
        return alunoRepository.findByActive(0);
    }

    public Optional<AlunoDTO> getAlunoById(Integer id) {
        return alunoRepository.findById(id).map(AlunoMapper::toAlunoDTO);
    }

    public Optional<AlunoDTO> criaAluno(AlunoDTO alunoDTO) {
        alunoDTO.setActive(1);

        return Optional.of(alunoRepository.save(AlunoMapper.toAluno(alunoDTO)))
                .map(AlunoMapper::toAlunoDTO);
    }

    public Optional<AlunoDTO> atualizaAluno(Integer id, AlunoDTO alunoDTO) {
        if (getAlunoById(id).isPresent()) {
            alunoDTO.setId(id);
            alunoDTO.setActive(1);

            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(AlunoMapper.toAluno(alunoDTO))));
        } else {
            return Optional.empty();
        }
    }

    public Optional<AlunoDTO> deletaAluno(Integer id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            aluno.get().setActive(0);
            mentoriaService.setAlunoActive(0, id);

            return Optional.of(AlunoMapper.toAlunoDTO(alunoRepository.save(aluno.get())));
        } else {
            return Optional.empty();
        }
    }
}

