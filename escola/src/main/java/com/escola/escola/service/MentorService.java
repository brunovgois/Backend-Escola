package com.escola.escola.service;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.model.Mentor;
import com.escola.escola.repository.MentorRepository;
import com.escola.escola.service.mapper.MentorMapper;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Mentor> getMentoresActive() {
        return mentorRepository.findByActive(1);
    }

    public Optional<MentorDTO> getMentorById(Integer id) {
        return mentorRepository.findById(id).map(MentorMapper::toMentorDTO);
    }


    public Optional<MentorDTO> criaMentor(MentorDTO mentorDTO) {
        mentorDTO.setActive(1);
        return Optional.of(MentorMapper.toMentorDTO(
                mentorRepository.save(MentorMapper.toMentor(mentorDTO)
                )));
    }

    public Optional<MentorDTO> deletaMentor(Integer id) {
        Optional<Mentor> mentor = mentorRepository.findById(id);

        if (mentor.isPresent()) {
            mentor.get().setActive(0);
            mentoriaService.setMentorActive(0, id);
            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(mentor.get())));
        } else {
            return Optional.empty();
        }
    }

    public Optional<MentorDTO> ativaMentor(Integer id) {
        Optional<Mentor> mentor = mentorRepository.findById(id);
        if (mentor.isPresent()) {
            mentor.get().setActive(1);
            mentoriaService.setMentorActive(1, id);
            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(mentor.get())));
        } else {
            return Optional.empty();
        }
    }

    public Optional<MentorDTO> atualizarMentor(Integer id, MentorDTO mentorDTO) {
        if (getMentorById(id).isPresent()) {
            mentorDTO.setId(id);
            mentorDTO.setActive(1);

            return Optional.of(MentorMapper.toMentorDTO(mentorRepository.save(MentorMapper.toMentor(mentorDTO))));
        } else
            return Optional.empty();
    }

}
