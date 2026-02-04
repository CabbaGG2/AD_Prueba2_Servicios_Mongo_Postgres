package org.example.service;

import org.example.model.Personaxe;
import org.example.model.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

@Service
public class ConexionService {

    @Autowired
    private RestTemplate restTemplate;


    private static final String POSTGRES_BASE_URL_XOGADORES = "http://localhost:8081/postgres/personaxes";
    private static final String POSTGRES_BASE_URL_SAGAS = "http://localhost:8081/postgres/saga";


    /*
    public List<Algo> operacionCaprichosa() {
        try {
            String url = POSTGRES_BASE_URL_XOGADORES;
            ResponseEntity<List<Algo>> response = restTemplate.exchange(
                    url, HttpMethod., null,
                    new ParameterizedTypeReference<List<Algo>>() {}
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Erro: " + e.getMessage());
            return Collections.emptyList();
        }
    }*/

    public List<Personaxe> getAllPersonaxes() {
        try{
            String url = POSTGRES_BASE_URL_XOGADORES;
            ResponseEntity<List<Personaxe>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Personaxe>>() {
                    }
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error buscando los personajes: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Saga> getAllSagas(){
        try{
            String url = POSTGRES_BASE_URL_SAGAS;
            ResponseEntity<List<Saga>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Saga>>() {
                    }
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error al traer las sagas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public Saga getSagaById(Long id){
        try{
            String url = POSTGRES_BASE_URL_SAGAS + "/" + id;
            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Saga.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e){
            System.out.println("Error al traer la saga con id: " + id + e.getMessage());
            return null;
        }
    }

    public Saga getSagaByTitulo(String titulo){
        try{
            String url = POSTGRES_BASE_URL_SAGAS + "/titulo/" + titulo;
            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Saga.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e){
            System.out.println("Error al traer la saga por titulo: " + titulo + e.getMessage());
            return null;
        }
    }
    /*
    public Algo operacionPedichona(Dato dato) {
        try {
            String url = ;
            ResponseEntity<Algo> response = restTemplate.exchange(
                    url, HttpMethod., null, .class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("NonNonNon non dixeche-la palabra maxica jajaja jajaja " + e.getMessage());
            return null;
        }
    }*/

    public Saga saveSaga(Saga saga){
        try{
            String url = POSTGRES_BASE_URL_SAGAS;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Saga> request = new HttpEntity<>(saga, headers);

            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Saga.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error al crear la saga: " + e.getMessage());
            return null;
        }
    }


    /*
    public Algo operacionConCorpo(Modelo model) {
        try {
            String url = ;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Personaxe> request = new HttpEntity<>(xogador, headers);

            ResponseEntity<Personaxe> response = restTemplate.exchange(
                    url, HttpMethod., request, .class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Erro xenerico: " + e.getMessage());
            return null;
        }
    }*/

    public boolean deleteAllSagas() {
        try{
            String url = POSTGRES_BASE_URL_SAGAS + "/borrarTodo";
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("No se pudo eliminar todas las sagas: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteAllPersonaxes() {
        try {
            String url = POSTGRES_BASE_URL_XOGADORES + "/borrarTodo";
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("No se pudo eliminar todos los personajes: " + e.getMessage());
            return false;
        }
    }
    /*
    public boolean algoPorID(Long id) {
        try {
            String url = ;
            restTemplate.exchange(url, HttpMethod., null, Void.class);
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("Mensaxe xenerica " + e.getMessage());
            return false;
        }
    }*/

}
