package com.escola.escola.service;

import com.escola.escola.dto.ProvaDTO;
import com.escola.escola.exception.ResourceNotFoundException;
import com.escola.escola.model.Prova;
import com.escola.escola.repository.ProvaRepository;
import com.escola.escola.service.mapper.ProvaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    @Autowired
    ProvaRepository provaRepository;

    @Autowired
    MentoriaService mentoriaService;

    @Autowired
    ProgramaService programaService;


    public List<Prova> getProvasAtivas() { return provaRepository.findByActive(1); }

    public List<Prova> getProvasInativas() { return provaRepository.findByActive(0); }

    public Optional<ProvaDTO> getProvaById(Integer id) {
        if(provaIdExiste(id)){
            return provaRepository.findById(id).map(ProvaMapper::toProvaDTO);
        } else
            throw new ResourceNotFoundException("Prova with id " + id + " not found");
    }

    public Optional<ProvaDTO> criaProva(ProvaDTO provaDTO) {
        if(mentoriaService.getMentoriaById(provaDTO.getMentoriaId()).isPresent() &&
            programaService.getProgramaById(provaDTO.getProgramaId()).isPresent()) {

            provaDTO.setActive(1);
            return Optional.of(ProvaMapper.toProvaDTO(provaRepository.save(ProvaMapper.toProva(provaDTO))));
        } else
            throw new ResourceNotFoundException("Mentoria or Programa not found on request body");
    }

    public Optional<ProvaDTO> deletaProva(Integer id) {
        Optional<Prova> prova = provaRepository.findById(id);
        if(prova.isPresent()) {
            prova.get().setActive(0);
            return Optional.of(ProvaMapper.toProvaDTO(provaRepository.save(prova.get())));
        } else {
            throw new ResourceNotFoundException("Prova with id " + id + " not found");
        }
    }

    public Optional<ProvaDTO> atualizaProva(Integer id, ProvaDTO provaDTO) {
        if(getProvaById(id).isPresent()) {
            provaDTO.setId(id);
            provaDTO.setActive(1);

            return Optional.of(ProvaMapper.toProvaDTO(provaRepository.save(ProvaMapper.toProva(provaDTO))));
        } else {
            throw new ResourceNotFoundException("Prova with id " + id + " not found");
        }
    }

    private boolean provaIdExiste(Integer id) {
        return provaRepository.existsById(id);
    }

}

