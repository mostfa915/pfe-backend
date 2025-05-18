package com.example.pfev2.repositorys;

import com.example.pfev2.entites.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationRepository extends JpaRepository<Communication, Integer> {
    Communication findById(Long id);
}
