package com.escola.escola.service;

import com.escola.escola.dto.AlunoDTO;
import com.escola.escola.exception.ResourceNotFoundException;
import com.escola.escola.model.Aluno;
import com.escola.escola.repository.AlunoRepository;
import com.escola.escola.dto.mapper.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    MentoriaService mentoriaService;

    @Autowired
    private AlunoMapper mapper;

    public Page<AlunoDTO> getAlunosAtivos(Pageable pageable) {
        return alunoRepository.findByActive(1, pageable).get().map(mapper::toAlunoDTO);
    }
    public Page<AlunoDTO> getAlunosInativos(Pageable pageable) {
        return alunoRepository.findByActive(0, pageable).get().map(mapper::toAlunoDTO);
    }

    public Optional<AlunoDTO> getAlunoById(Integer id) {
        if(alunoIdExiste(id)) {
            return alunoRepository.findById(id).map(mapper::toAlunoDTO);
        } else {
            throw new ResourceNotFoundException("Student with id " + id + " not found.");
        }
    }

    public Optional<AlunoDTO> criaAluno(AlunoDTO alunoDTO) {
        alunoDTO.setActive(1);

        return Optional.of(alunoRepository.save(mapper.toAluno(alunoDTO)))
                .map(mapper::toAlunoDTO);
    }

    public Optional<AlunoDTO> atualizaAluno(Integer id, AlunoDTO alunoDTO) {
        if (getAlunoById(id).isPresent()) {
            alunoDTO.setId(id);
            alunoDTO.setActive(1);

            return Optional.of(mapper.toAlunoDTO(alunoRepository.save(mapper.toAluno(alunoDTO))));
        } else {
            throw new ResourceNotFoundException("Student with id" + id + " not found.");
        }
    }

    @Transactional
    public Optional<AlunoDTO> deletaAluno(Integer id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            aluno.get().setActive(0);

//            mentoriaService.setAlunoActive(0, id);
//TODO checar se aluno esta em alguma mentoria antes de desativa-lo
            

            return Optional.of(mapper.toAlunoDTO(alunoRepository.save(aluno.get())));
        } else {
            throw new ResourceNotFoundException("Student with id " + id + " not found.");
        }
    }

    private boolean alunoIdExiste(Integer id) {
        return alunoRepository.existsById(id);
    }
}

