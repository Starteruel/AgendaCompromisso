package com.agenda.AgendaCompromisso.mappers;

import com.agenda.AgendaCompromisso.dtos.AgendaRequest;
import com.agenda.AgendaCompromisso.dtos.AgendaResponse;
import com.agenda.AgendaCompromisso.entities.Agenda;

public class AgendaMapper {

    public static AgendaResponse toDTO(Agenda agenda){
        return new AgendaResponse ( agenda.getId(),
        agenda.getName(), 
        agenda.getDays1(), 
        agenda.getHours2(),
        agenda.getLocation3());
    }

    public static Agenda toEntity(AgendaRequest agendaRequest){
        Agenda agenda = new Agenda();
        agenda.setName(agendaRequest.name());
        agenda.setDays1(agendaRequest.days1());
        agenda.setHours2(agendaRequest.hours2());
        agenda.setLocation3(agendaRequest.location3());

        return agenda;
    }
}
