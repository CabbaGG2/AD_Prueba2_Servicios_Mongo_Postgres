package org.example.service;

import org.example.model.Saga;
import org.example.repository.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SagaService {

    @Autowired
    private SagaRepository sagaRepo;

    public List<Saga> findAll() {
        return sagaRepo.findAll();
    }

    public Optional<Saga> findById(Long id){
        return sagaRepo.findById(id);
    }

    public Optional<List<Saga>> findByTitulo(String titulo){
        return sagaRepo.findByTitulo(titulo);
    }

    public Saga crearActualizarSaga(Saga saga){
        return sagaRepo.save(saga);
    }

    public void detellaAll(){
        sagaRepo.deleteAll();
    }

    

}
