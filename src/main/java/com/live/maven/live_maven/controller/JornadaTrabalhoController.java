package com.live.maven.live_maven.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.live.maven.live_maven.model.JornadaTrabalho;
import com.live.maven.live_maven.repository.JornadaRepository;
import com.live.maven.live_maven.service.JornadaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;
    
    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.save(jornadaTrabalho);      
    }
    @GetMapping
    public List<JornadaTrabalho> getjornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getjornadaById(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok( jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not Found")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.update(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public Map<String, Boolean> deleteByID(@PathVariable(value = "idJornada") Long idJornada)
    throws Exception {
     jornadaService.getById(idJornada).orElseThrow(() -> new Exception("Não encontrado"));
    
     jornadaService.delete(idJornada);
     Map<String, Boolean> response = new HashMap<>();
     response.put("deleted", Boolean.TRUE);
     return response;
}
}
