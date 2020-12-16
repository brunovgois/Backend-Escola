package com.escola.escola.service;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.exception.ResourceNotFoundException;
import com.escola.escola.model.Mentor;
import com.escola.escola.repository.MentorRepository;
import com.escola.escola.dto.mapper.MentorMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MentorService {

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    MentoriaService mentoriaService;

    @Autowired
    private MentorMapper mapper;

    public Page<MentorDTO> getMentoresActive(Pageable pageable) {
        return mentorRepository.findByActive(1, pageable).get().map(mapper::toMentorDTO);
    }

    public Page<MentorDTO> getMentoresInativos(Pageable pageable) {
        return mentorRepository.findByActive(0, pageable).get().map(mapper::toMentorDTO);
    }

    public Optional<MentorDTO> getMentorById(Integer id) {
        if(mentorIdExiste(id)) {
            return mentorRepository.findById(id).map(mapper::toMentorDTO);
        } else {
            throw new ResourceNotFoundException("Mentor with id " + id + " not found");
        }
    }


    public Optional<MentorDTO> criaMentor(MentorDTO mentorDTO) {
        mentorDTO.setActive(1);
        return Optional.of(mentorRepository.save(mapper.toMentor(mentorDTO))).map(mapper::toMentorDTO);
    }

    @Transactional
    public Optional<MentorDTO> deletaMentor(Integer id) {
        Optional<Mentor> mentor = mentorRepository.findById(id);

        if (mentor.isPresent()) {
            mentor.get().setActive(0);
            mentoriaService.setMentorActive(0, id);
            return Optional.of(mapper.toMentorDTO(mentorRepository.save(mentor.get())));
        } else
            throw new ResourceNotFoundException("Mentor with id " + id + " not found.");
    }

    public Optional<MentorDTO> atualizarMentor(Integer id, MentorDTO mentorDTO) {
        if (getMentorById(id).isPresent()) {
            mentorDTO.setId(id);
            mentorDTO.setActive(1);

            return Optional.of(mapper.toMentorDTO(mentorRepository.save(mapper.toMentor(mentorDTO))));
        } else
            throw new ResourceNotFoundException("Mentor with id " + id + "not found");
    }
    private boolean mentorIdExiste(Integer id) {
        return mentorRepository.existsById(id);
    }
}
