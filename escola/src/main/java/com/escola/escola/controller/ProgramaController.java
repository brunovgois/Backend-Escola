package com.escola.escola.controller;

import com.escola.escola.dto.ProgramaDTO;
import com.escola.escola.model.Programa;
import com.escola.escola.service.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("programa")
public class ProgramaController {
    
    @Autowired
    ProgramaService programaService;

    @PostMapping
    public ResponseEntity<ProgramaDTO> criarPrograma(@RequestBody ProgramaDTO programaDTO) {
        return programaService.criaPrograma(programaDTO)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<Programa>> getProgramas() {
        return new ResponseEntity<>(programaService.getProgramasAtivos(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaDTO> getProgramaById(@PathVariable Integer id) {
        return programaService.getProgramaById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaDTO> atualizaPrograma(@PathVariable("id") Integer id,
                                                  @RequestBody ProgramaDTO programaDTO) {
        return programaService.atualizaPrograma(id, programaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgramaDTO> deletarPrograma(@PathVariable Integer id) {
        return programaService.deletaPrograma(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
