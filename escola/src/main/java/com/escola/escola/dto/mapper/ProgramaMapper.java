package com.escola.escola.dto.mapper;

import com.escola.escola.dto.ProgramaDTO;
import com.escola.escola.model.Programa;

public class ProgramaMapper {
    public static Programa toPrograma(ProgramaDTO programaDTO) {
        Programa programa = new Programa();

        programa.setId(programaDTO.getId());
        programa.setName(programaDTO.getName());
        programa.setStartDate(programaDTO.getStartDate());
        programa.setActive(programaDTO.getActive());

        return programa;
    }

    public static ProgramaDTO toProgramaDTO(Programa programa) {
        ProgramaDTO programaDTO = new ProgramaDTO();

        programaDTO.setId(programa.getId());
        programaDTO.setName(programa.getName());
        programaDTO.setActive(programa.getActive());
        programaDTO.setStartDate(programa.getStartDate());

        return programaDTO;
    }
}
