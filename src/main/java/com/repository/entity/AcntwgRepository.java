package com.repository.entity;

import com.model.Acntwg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository(value = "AcntwgRepository")
public interface AcntwgRepository extends JpaRepository<Acntwg, String> {

    @Transactional
    @Query(value = "select u.wage FROM Acntwg u where u.acntno = ?1")
    Double getwage(String acntno);
}
