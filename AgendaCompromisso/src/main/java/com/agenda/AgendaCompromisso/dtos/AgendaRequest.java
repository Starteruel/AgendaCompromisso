package com.agenda.AgendaCompromisso.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AgendaRequest(
    
    @NotBlank(message = "Nome não pode ser em branco")
    @Size(min = 5, message = "Minimo de 5 letras")
    String name,
    
    @Min(value = 0, message = "Dias não podem ser menor que 0")
    Double days1,

    @Min(value = 0, message = "Horas não podem ser menores que 0")
    Double hours2,
    
    @NotBlank(message = "Localidade não pode ser em branco")
    String location3
) {
    
}
