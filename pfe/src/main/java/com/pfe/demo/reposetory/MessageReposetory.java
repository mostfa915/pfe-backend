package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageReposetory extends JpaRepository<Message,Long> {

    @Query("select  p from Message p where p.idDestinataire.id like :x   order by p.id desc   ")

    List<Message> messagebyartisan(@Param("x") Long id);
}
