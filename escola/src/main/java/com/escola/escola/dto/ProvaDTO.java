package com.escola.escola.dto;
import java.time.LocalDate;

public class ProvaDTO {

    private Integer id;
    private Integer mentoriaId;
    private Integer programaId;
    private Double nota;
    private LocalDate data;
    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMentoriaId() {
        return mentoriaId;
    }

    public void setMentoriaId(Integer mentoriaId) {
        this.mentoriaId = mentoriaId;
    }

    public Integer getProgramaId() {
        return programaId;
    }

    public void setProgramaId(Integer programaId) {
        this.programaId = programaId;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
