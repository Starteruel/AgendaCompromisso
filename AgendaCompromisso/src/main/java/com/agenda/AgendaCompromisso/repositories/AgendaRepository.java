package com.agenda.AgendaCompromisso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.AgendaCompromisso.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    
}
