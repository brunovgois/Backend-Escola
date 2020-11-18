package com.escola.escola.controller;

import com.escola.escola.dto.ProvaDTO;
import com.escola.escola.model.Prova;
import com.escola.escola.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class ProvaController {

    @Autowired
    ProvaService provaService;

    @GetMapping
    public List<Prova> getProvas() { return provaService.getProvasAtivas(); }

    @GetMapping("/{id}")
    public ResponseEntity<ProvaDTO> getProvaById(@PathVariable Integer id) {
        return provaService.getProvaById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/inativos")
    public List<Prova> getProvasInativas() {return provaService.getProvasInativas(); }

    @PostMapping
    public ResponseEntity<ProvaDTO> createProva(@RequestBody ProvaDTO provaDTO) {
        return provaService.criaProva(provaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvaDTO> updateProva(@PathVariable("id") Integer id, @RequestBody ProvaDTO provaDTO) {
        return provaService.atualizaProva(id, provaDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProvaDTO> deleteProva(@PathVariable Integer id) {
        return provaService.deletaProva(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

