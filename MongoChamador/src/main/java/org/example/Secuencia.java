package org.example;

import org.example.model.Personaxe;
import org.example.model.Saga;
import org.example.service.ConexionService;
import org.example.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Secuencia {

    @Autowired
    private ConexionService conexionService;
    @Autowired
    private SagaService sagaService;

    public void executar() {

        List<Personaxe> personajes = new ArrayList<>();

        Personaxe p1 = new Personaxe();
        p1.setNome("Giorno Giovanna");
        p1.setStand("Gold Experience");

        Personaxe p2 = new Personaxe();
        p2.setNome("Bruno Bucciarati");
        p2.setStand("Sticky Fingers");

        Personaxe p3 = new Personaxe();
        p3.setNome("Guido Mista");
        p3.setStand("Sex Pistols");

        personajes.add(p1);
        personajes.add(p2);
        personajes.add(p3);

        Saga saga = new Saga();
        saga.setTitulo("Vento Aureo");
        saga.setParte(5);
        saga.setAmbientacion("Italia");
        saga.setAnoinicio(2001);
        saga.setPersonaxes(personajes);

        Saga saga1 = conexionService.saveSaga(saga);

        Saga sagaConId = conexionService.getSagaById(2L);

        sagaService.crearActualizarSaga(sagaConId);

        Saga sagaConTitulo = conexionService.getSagaByTitulo("Stardust Crusaders");

        sagaService.crearActualizarSaga(sagaConTitulo);

        List<Saga> todasSagas = conexionService.getAllSagas();

        for (Saga s: todasSagas) {
            sagaService.crearActualizarSaga(s);
        }

        conexionService.deleteAllPersonaxes();

        conexionService.deleteAllSagas();

        sagaService.detellaAll();
    }
}
