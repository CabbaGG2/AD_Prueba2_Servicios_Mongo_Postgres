package org.example.service;

import com.google.gson.Gson;
import org.example.model.Saga;
import org.example.repository.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
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


    public boolean existsById(Long id){
        return sagaRepo.existsById(id);
    }

    public void deleteById(Long id){
        sagaRepo.deleteById(id);
    }

    public void exportarJson() {
        Gson gson = new Gson();
        List<Saga> sagas = sagaRepo.findAll();
        try(FileWriter escritor = new FileWriter("src/main/java/org/example/json/sagas.json")){
            gson.toJson(sagas, escritor);
        }catch (Exception e) {
            System.out.println("Error al exportar a JSON: " + e.getMessage());
        }
    }
    

}
