package org.example;


import org.example.model.LosJojos;
import org.example.model.Personaxe;
import org.example.model.Saga;
import org.example.service.ConexionMongoService;
import org.example.service.ConexionPostgresService;
import org.example.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Secuencia {

    @Autowired
    private ConexionPostgresService conexionPostgresService;

    @Autowired
    private ConexionMongoService conexionMongoService;

    @Autowired
    private JsonService jsonService;

    public void executar(){
        ArrayList<Personaxe> personajes = new ArrayList();

        Personaxe p1 = new Personaxe();
        p1.setNome("Giorno Giovanna");
        p1.setStand("Gold Experience");
        personajes.add(p1);

        Personaxe p2 = new Personaxe();
        p2.setNome("Bruno Bucciarati");
        p2.setStand("Sticky Fingers");
        personajes.add(p2);

        Personaxe p3 = new Personaxe();
        p3.setNome("Guido Mista");
        p3.setStand("Sex Pistols");
        personajes.add(p3);

        Saga saga = new Saga();
        saga.setTitulo("Vento Aureo");
        saga.setParte(5);
        saga.setAmbientacion("Italia");
        saga.setAnoinicio(2001);
        saga.setPersonaxes(personajes);

        System.out.println("Creamos la saga en la base de datos de Postgres");

        //saga = conexionPostgresService.crearSaga(saga);

        System.out.println("Traemos de Postgres una saga por ID");

        Saga saga2 = conexionPostgresService.sagaPorID(2L);

        System.out.println("Trajimos la saga: " + saga2.getTitulo());

        System.out.println("Traemos de Postgres una saga por Nombre");

        Saga saga3 = conexionPostgresService.sagaPorTitulo("Stardust Crusaders");

        System.out.println("Trajimos la saga: " + saga3.getTitulo());

        System.out.println("Las guardamos en Mongo");

        System.out.println("Enviando a Mongo saga: " + saga2.getTitulo() + " con ID: " + saga2.getIdsaga());
        conexionMongoService.crearSaga(saga2);

        System.out.println("Enviando a Mongo saga: " + saga3.getTitulo() + " con ID: " + saga3.getIdsaga());
        conexionMongoService.crearSaga(saga3);

        List<Saga> sagas = conexionPostgresService.buscarSagas();
        for(Saga s: sagas){
            System.out.println(s.getIdsaga() +  "creamos la saga: " + s.getTitulo() + " en Mongo.");
            conexionMongoService.crearSaga(s);
        }

        System.out.println("Creamos un objeto jojos");
        LosJojos losJojos = new LosJojos();

        System.out.println("seteamos sagas en los jojos");
        losJojos.setSagas(sagas);

        System.out.println(losJojos);

        System.out.println("Creamos un documento 'jojos' en Mongo.");

        //LosJojos j = conexionMongoService.crearJojos(new LosJojos());
        LosJojos j = conexionMongoService.crearJojos(losJojos);
        System.out.println(j);
    }
}
