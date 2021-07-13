package com.live.maven.live_maven.repository;

import com.live.maven.live_maven.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornadaRepository extends JpaRepository<JornadaTrabalho,Long> {
    
}
