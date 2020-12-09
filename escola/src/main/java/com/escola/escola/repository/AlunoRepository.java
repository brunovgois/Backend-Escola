package com.escola.escola.repository;

import com.escola.escola.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
    Optional<Page<Aluno>> findByActive(Integer active, Pageable pageable);

    boolean existsById(Integer id);

}
