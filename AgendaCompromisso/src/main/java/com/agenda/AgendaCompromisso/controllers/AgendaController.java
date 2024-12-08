package com.agenda.AgendaCompromisso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.AgendaCompromisso.dtos.AgendaRequest;
import com.agenda.AgendaCompromisso.dtos.AgendaResponse;
import com.agenda.AgendaCompromisso.services.AgendaService;

@RestController
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaResponse>> GetAgenda(){
        return ResponseEntity.ok(service.getAllAgenda());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaResponse>GetAgenda(@PathVariable Long id){
        return ResponseEntity.ok(service.getAgendabyId(id));
    }
    
    @PutMapping("{id}")
public ResponseEntity<Void> updateAgenda(@PathVariable Long id, @Validated @RequestBody AgendaRequest Agenda) {
    service.uptade(Agenda, id);
    return ResponseEntity.ok().build();
}

@DeleteMapping("{id}")
public ResponseEntity<Void> deleteAgenda(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
}

}
