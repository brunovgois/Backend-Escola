package com.escola.escola.service;

import com.escola.escola.dto.ProgramaDTO;
import com.escola.escola.exception.ResourceNotFoundException;
import com.escola.escola.model.Programa;
import com.escola.escola.repository.ProgramaRepository;
import com.escola.escola.service.mapper.ProgramaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaService {

    @Autowired
    ProgramaRepository programaRepository;

    public List<Programa> getProgramasAtivos() {
        return programaRepository.findByActive(1);
    }

    public Optional<ProgramaDTO> getProgramaById(Integer id) {
        if(programaIdExiste(id)) {
            return programaRepository.findById(id).map(ProgramaMapper::toProgramaDTO);
        } else
            throw new ResourceNotFoundException("Programa with id " + id + " not found");
    }

    public Optional<ProgramaDTO> criaPrograma(ProgramaDTO programaDTO) {
        programaDTO.setActive(1);

        return Optional.of(programaRepository.save(ProgramaMapper.toPrograma(programaDTO)))
                .map(ProgramaMapper::toProgramaDTO);
    }

    public Optional<ProgramaDTO> atualizaPrograma(Integer id, ProgramaDTO programaDTO) {
        if (getProgramaById(id).isPresent()) {
            programaDTO.setId(id);
            programaDTO.setActive(1);

            return Optional.of(ProgramaMapper.toProgramaDTO(programaRepository.save(ProgramaMapper.toPrograma(programaDTO))));
        } else {
            throw new ResourceNotFoundException("Programa with id " + id + " not found");
        }
    }

    public Optional<ProgramaDTO> deletaPrograma(Integer id) {
        Optional<Programa> programa = programaRepository.findById(id);

        if (programa.isPresent()) {
            programa.get().setActive(0);
            return Optional.of(ProgramaMapper.toProgramaDTO(programaRepository.save(programa.get())));
        } else
            throw new ResourceNotFoundException("Programa with id " + id + " not found");
    }

    private boolean programaIdExiste(Integer id) {
        return programaRepository.existsById(id);
    }
}
