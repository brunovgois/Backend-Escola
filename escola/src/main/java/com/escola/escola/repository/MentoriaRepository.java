package com.escola.escola.repository;

import com.escola.escola.model.Mentoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentoriaRepository extends CrudRepository<Mentoria, Integer> {
    List<Mentoria> findByActive(Integer active);

    @Modifying
    @Query(value = "update mentoria set active = ?1 where aluno in (select id from aluno where id = ?2)", nativeQuery = true)
    void setActiveByAlunoId(Integer active, Integer id);

    @Modifying
    @Query(value = "update mentoria set active = ?1 where mentor in (select id from mentor where id = ?2)", nativeQuery = true)
    void setActiveByMentorId(Integer active, Integer id);
}
