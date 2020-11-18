package com.escola.escola.repository;

import com.escola.escola.model.Prova;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvaRepository extends CrudRepository<Prova, Integer> {
    List<Prova> findByActive(Integer active);

    boolean existsById(Integer id);
}
