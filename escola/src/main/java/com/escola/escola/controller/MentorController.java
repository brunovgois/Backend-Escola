package com.escola.escola.controller;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.model.Mentor;
import com.escola.escola.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {
    @Autowired
    MentorService mentorService;

    @GetMapping
    public ResponseEntity<Page<MentorDTO>> getMentores(@PageableDefault(sort="name", direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(mentorService.getMentoresActive(pageable), HttpStatus.ACCEPTED);
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<MentorDTO>> getMentoresInativos(@PageableDefault(sort="name", direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>(mentorService.getMentoresInativos(pageable), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentorDTO> getMentorById(@PathVariable Integer id) {
        return mentorService.getMentorById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MentorDTO> criaMentor(@RequestBody MentorDTO mentorDTO) {
        return mentorService.criaMentor(mentorDTO).map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorDTO> atualizarMentor(@PathVariable("id") Integer id, @RequestBody MentorDTO mentorDTO){
        return mentorService.atualizarMentor(id, mentorDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentorDTO> deletaMentor(@PathVariable Integer id) {
        return mentorService.deletaMentor(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
