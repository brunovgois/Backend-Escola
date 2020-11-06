package com.escola.escola.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Mentoria mentoria;

    @ManyToOne
    private Programa programa;

    private Double nota;

    private LocalDate data;

    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mentoria getMentoria() {
        return mentoria;
    }

    public void setMentoria(Mentoria mentoria) {
        this.mentoria = mentoria;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
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
