package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiscussionReposetory extends JpaRepository<Discussion,Long> {
    @Query("select p from Discussion p where (p.user1 like :x and p.user2 like :x2) or (p.user2 like :x and p.user1 like :x2) ")
    Discussion findDiscussio( @Param("x") String user1 ,@Param("x2") String user2  );
    @Query("select p from Discussion p where p.id like :x")
    Discussion find( @Param("x") Long u );
    @Query("select  p from Discussion p where p.user2 like :x ")
    List<Discussion> messagebyartisan(@Param("x") String username);
}

