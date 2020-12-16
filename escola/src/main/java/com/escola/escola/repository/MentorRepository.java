package com.escola.escola.repository;

import com.escola.escola.model.Mentor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Integer> {
    Optional<Page<Mentor>> findByActive(Integer active, Pageable pageable);

    boolean existsById(Integer id);

}
