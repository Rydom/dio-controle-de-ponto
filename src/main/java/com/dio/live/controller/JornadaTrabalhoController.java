package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    JornadaService jornadaService;


    @PostMapping()
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JornadaTrabalho> getJornadaListById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(jornadaService.getById(id).orElseThrow(() -> new NoSuchElementException("Jornada não encontrada.")));
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteByID(@PathVariable("id") Long id) throws Exception {
        try {
            jornadaService.deleteJornada(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }
}
