package com.escola.escola.repository;

import com.escola.escola.model.Programa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, Integer> {
    List<Programa> findByActive(Integer active);

    boolean existsById(Integer id);
}
