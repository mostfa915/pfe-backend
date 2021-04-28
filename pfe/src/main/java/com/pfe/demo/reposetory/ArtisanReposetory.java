package com.pfe.demo.reposetory;

import com.pfe.demo.entiter.Artisan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtisanReposetory extends JpaRepository<Artisan,Long> {
    @Query("select p from Artisan p where p.id like :x")
    Artisan findbyId( @ Param("x") Long id);

    @Query("select p from Artisan p where p.username like : x")
    Artisan findbyname(@Param('%'+"x"+'%') String mc);
    @Query("select  p from Artisan p order by p.id desc")
    List<Artisan>alldesc();
    @Query("select  p from Artisan p where p.dateinscription like  "+'%'+":x"+'%')

    List<Artisan> artisanderniermm(@Param("x") String date);


}
