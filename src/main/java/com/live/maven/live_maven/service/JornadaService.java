package com.live.maven.live_maven.service;

import java.util.List;
import java.util.Optional;

import com.live.maven.live_maven.model.JornadaTrabalho;
import com.live.maven.live_maven.repository.JornadaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JornadaService {
    
    
    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository){
        this.jornadaRepository = jornadaRepository;
    }

    public JornadaTrabalho save(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
        
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> getById(Long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho update(JornadaTrabalho jornadaTrabalho) {
        return jornadaRepository.save(jornadaTrabalho);
        
    }

    public void delete(Long idJornada) {
        jornadaRepository.deleteById(idJornada);

    }
    
}
