package org.example.service;

import org.example.model.LosJojos;
import org.example.model.Saga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ConexionMongoService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String MONGO_BASE_URL_JOJOS = "http://localhost:8080/mongo/jojos";
    private static final String MONGO_BASE_URL_SAGA = "http://localhost:8080/mongo/saga";

    //---------------- SAGAS ----------------------------

    public List<Saga> buscarSagas(){
        try {
            String url = MONGO_BASE_URL_SAGA;
            ResponseEntity<List<Saga>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Saga>>(){}
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error al traer las sagas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public boolean borrarSaga(Long id){
        try{
            String url = MONGO_BASE_URL_SAGA + "/" + id;
            ResponseEntity<Void> response = restTemplate.exchange(
                    url, HttpMethod.DELETE, null, Void.class
            );
            return true;
        } catch (HttpClientErrorException e) {
            System.out.println("Error al borrar la saga en Mongo: " + e.getMessage());
            return false;
        }
    }

    public Saga crearSaga(Saga saga){
        try {
            String url = MONGO_BASE_URL_SAGA;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Saga> request = new HttpEntity<Saga>(saga, headers);

            ResponseEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, Saga.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error intentando ingresar una saga en Mongo: " + e.getMessage());
            return  null;
        }
    }

    public Saga buscarSagaPorId(Long id){
        try {
            String url = MONGO_BASE_URL_SAGA + "/" + id;
            HttpEntity<Saga> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, Saga.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error buscando saga por id en mongo: " + e.getMessage());
            return null;
        }
    }

    public Saga buscarSagaPorTitulo(String titulo){
        try{
            String url = MONGO_BASE_URL_SAGA + "/titulo/" + titulo;
            HttpEntity<List<Saga>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Saga>>() {});
            List<Saga> s = response.getBody();
            return s.get(0);
        } catch (HttpClientErrorException e) {
            System.out.println("Error al cargar la saga por titulo en Mongo: " + e.getMessage());
            return null;
        }
    }

    //------------------ JOJOS -----------------

    public LosJojos crearJojos(LosJojos losJojos){
        try {
            String url = MONGO_BASE_URL_JOJOS;
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<LosJojos> request = new HttpEntity<>(losJojos, headers);

            ResponseEntity<LosJojos> response = restTemplate.exchange(
                    url, HttpMethod.POST, request, LosJojos.class
            );
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("Error al crear los jojos en Mongo: " + e.getMessage());
            return null;
        }
    }

    public List<LosJojos> buscarLosjojos(){
        try {
            String url = MONGO_BASE_URL_JOJOS;
            ResponseEntity<List<LosJojos>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<LosJojos>>() {}
            );
            return response.getBody() != null ? response.getBody() : Collections.emptyList();
        } catch (HttpClientErrorException e) {
            System.out.println("Error al cargar los jojos desde mongo: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
