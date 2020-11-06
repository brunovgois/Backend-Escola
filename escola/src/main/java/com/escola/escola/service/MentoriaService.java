package com.escola.escola.service;

import com.escola.escola.dto.MentoriaDTO;
import com.escola.escola.model.Mentoria;
import com.escola.escola.repository.MentoriaRepository;
import com.escola.escola.service.mapper.MentoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentoriaService {

    @Autowired
    MentoriaRepository mentoriaRepository;

    @Autowired
    MentorService mentorService;

    @Autowired
    AlunoService alunoService;

    public Optional<MentoriaDTO> criaMentoria(MentoriaDTO mentoriaDTO) {
        if (alunoService.getAlunoById(mentoriaDTO.getAlunoId()).isPresent() &&
                mentorService.getMentorById(mentoriaDTO.getMentorId()).isPresent()) {
            mentoriaDTO.setActive(1);

            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository
                    .save(MentoriaMapper.toMentoria(mentoriaDTO))));
        } else {
            return Optional.empty();
        }
    }

    public List<Mentoria> getMentoriasAtivas() {
        return mentoriaRepository.findByActive(1);
    }

    public List<Mentoria> getMentoriasInativas() {
        return mentoriaRepository.findByActive(0);
    }

    public Optional<MentoriaDTO> getMentoriaById(Integer id) {
        return mentoriaRepository.findById(id).map(MentoriaMapper::toMentoriaDTO);
    }

    public Optional<MentoriaDTO> deleteMentoria(Integer id) {
        Optional<Mentoria> mentoria = mentoriaRepository.findById(id);
        if (mentoria.isPresent()) {
            mentoria.get().setActive(0);
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(mentoria.get())));
        } else {
            return Optional.empty();
        }
    }


    public Optional<MentoriaDTO> atualizaMentoria(Integer id, MentoriaDTO mentoriaDTO) {

        if (alunoService.getAlunoById(id).isPresent() &&
                mentorService.getMentorById(mentoriaDTO.getMentorId()).isPresent()) {
            mentoriaDTO.setId(id);
            return Optional.of(MentoriaMapper.toMentoriaDTO(mentoriaRepository.save(MentoriaMapper.toMentoria(mentoriaDTO))));
        } else {
            return Optional.empty();
        }
    }


    public void setMentorActive(Integer active, Integer id) {
        mentoriaRepository.setActiveByAlunoId(active, id);
    }

    public void setAlunoActive(Integer active, Integer id) {
        mentoriaRepository.setActiveByMentorId(active, id);
    }
}
