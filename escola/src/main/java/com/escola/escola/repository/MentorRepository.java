package com.escola.escola.repository;

import com.escola.escola.model.Mentor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Integer> {
    List<Mentor> findByActive(Integer active);

    boolean existsById(Integer id);

}
