package com.escola.escola.controller;


import com.escola.escola.dto.AlunoDTO;
import com.escola.escola.model.Aluno;
import com.escola.escola.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> getAlunos(@PageableDefault(sort ="name", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(alunoService.getAlunosAtivos(pageable), HttpStatus.ACCEPTED);
    }

    @GetMapping("/inativos")
    public ResponseEntity<Page<AlunoDTO>> getAlunosInativos(@PageableDefault(sort ="name", direction = Sort.Direction.ASC) Pageable pageable) {
        return new ResponseEntity<>(alunoService.getAlunosInativos(pageable), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> getAlunoById(@PathVariable Integer id) {
        return alunoService.getAlunoById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> criarAluno(@RequestBody AlunoDTO alunoDTO) {
        return alunoService.criaAluno(alunoDTO)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizaAluno(@PathVariable("id") Integer id,
                                                  @RequestBody AlunoDTO alunoDTO) {
        return alunoService.atualizaAluno(id, alunoDTO).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoDTO> deletarAluno(@PathVariable Integer id) {
        return alunoService.deletaAluno(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
