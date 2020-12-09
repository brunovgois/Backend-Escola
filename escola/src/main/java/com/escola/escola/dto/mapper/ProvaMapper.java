package com.escola.escola.dto.mapper;

import com.escola.escola.dto.ProvaDTO;
import com.escola.escola.model.Mentoria;
import com.escola.escola.model.Programa;
import com.escola.escola.model.Prova;

public class ProvaMapper {
    public static Prova toProva(ProvaDTO provaDTO) {
        Prova prova = new Prova();
        Mentoria mentoria = new Mentoria();
        Programa programa = new Programa();

        mentoria.setId(provaDTO.getMentoriaId());
        programa.setId(provaDTO.getProgramaId());

        prova.setId(provaDTO.getId());
        prova.setData(provaDTO.getData());
        prova.setNota(provaDTO.getNota());
        prova.setMentoria(mentoria);
        prova.setPrograma(programa);
        prova.setActive(provaDTO.getActive());

        return prova;
    }

    public static ProvaDTO toProvaDTO(Prova prova) {
        ProvaDTO provaDTO = new ProvaDTO();

        provaDTO.setId(prova.getId());
        provaDTO.setData(prova.getData());
        provaDTO.setNota(prova.getNota());
        provaDTO.setMentoriaId(prova.getMentoria().getId());
        provaDTO.setProgramaId(prova.getPrograma().getId());
        provaDTO.setActive(prova.getActive());

        return provaDTO;
    }
}
