package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class Saga {

    private Long idsaga;

    private String titulo;
    private int parte;
    private int anoinicio;
    private String ambientacion;

    private List<Personaxe> personaxes;

    public Long getIdsaga() {
        return idsaga;
    }

    public void setIdsaga(Long idsaga) {
        this.idsaga = idsaga;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getParte() {
        return parte;
    }

    public void setParte(int parte) {
        this.parte = parte;
    }

    public int getAnoinicio() {
        return anoinicio;
    }

    public void setAnoinicio(int anoinicio) {
        this.anoinicio = anoinicio;
    }

    public String getAmbientacion() {
        return ambientacion;
    }

    public void setAmbientacion(String ambientacion) {
        this.ambientacion = ambientacion;
    }

    public List<Personaxe> getPersonaxes() {
        return personaxes;
    }

    public void setPersonaxes(List<Personaxe> personaxes) {
        this.personaxes = personaxes;
    }}

