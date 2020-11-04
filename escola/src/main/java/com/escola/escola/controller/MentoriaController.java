package com.escola.escola.controller;

import com.escola.escola.dto.MentorDTO;
import com.escola.escola.dto.MentoriaDTO;
import com.escola.escola.model.Mentoria;
import com.escola.escola.repository.MentoriaRepository;
import com.escola.escola.service.AlunoService;
import com.escola.escola.service.MentorService;
import com.escola.escola.service.MentoriaService;
import com.escola.escola.service.mapper.MentoriaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/mentoria")
public class MentoriaController {

    @Autowired
    MentoriaService mentoriaService;

    @GetMapping
    public List<Mentoria> getMentorias(){
        return mentoriaService.getMentoriasAtivas();
    }

    @GetMapping("/inativos")
    public List<Mentoria> getMentoriasInativas(){
        return mentoriaService.getMentoriasInativas();
    }

    @PostMapping
    public ResponseEntity<MentoriaDTO> createMentoria(@RequestBody MentoriaDTO mentoriaDTO){
        return mentoriaService.criaMentoria(mentoriaDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentoriaDTO> updateMentoria(@PathVariable("id") Integer id, @RequestBody MentoriaDTO mentoriaDTO){
        return mentoriaService.atualizaMentoria(id, mentoriaDTO).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MentoriaDTO> deleteMentoria(@PathVariable Integer id){
        return mentoriaService.deleteMentoria(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
