package com.agenda.AgendaCompromisso.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.AgendaCompromisso.dtos.AgendaRequest;
import com.agenda.AgendaCompromisso.dtos.AgendaResponse;
import com.agenda.AgendaCompromisso.entities.Agenda;
import com.agenda.AgendaCompromisso.mappers.AgendaMapper;
import com.agenda.AgendaCompromisso.repositories.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {
    
    @Autowired
    private AgendaRepository repository;

    public void save(){}

    public List<AgendaResponse> getAllAgenda() {
    return repository.findAll().stream().map(p -> AgendaMapper.toDTO(p)).collect(Collectors.toList());
    }

    public AgendaResponse getAgendabyId(Long id){
    Agenda agenda = repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Agenda não cadastrada")
    );

    return AgendaMapper.toDTO(agenda);
    }

    public void delete(Long id){
        if(repository.existsById(id)){
        repository.deleteById(id);

        }
        else {
        throw new EntityNotFoundException("Produto não Cadastrado");
        }
    }
    
    public AgendaResponse save(AgendaRequest Agenda){
        Agenda newAgenda = repository.save(AgendaMapper.toEntity(Agenda));
        return AgendaMapper.toDTO(newAgenda);
    }

    public void uptade(AgendaRequest agenda, Long id) {
        Agenda aux = repository.getReferenceById(id);
        aux.setName(agenda.name());
        aux.setDays1(agenda.days1());
        aux.setHours2(agenda.hours2());
        aux.setLocation3(agenda.location3());
        
        repository.save(aux);
    }

}

