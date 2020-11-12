package com.escola.escola.repository;

import com.escola.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
    List<Aluno> findByActive(Integer active);

    boolean existsById(Integer id);

}
