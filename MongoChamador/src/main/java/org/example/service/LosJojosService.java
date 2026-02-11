package org.example.service;

import com.google.gson.Gson;
import org.example.model.LosJojos;
import org.example.repository.JojosRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

@Service
public class LosJojosService {
    private JojosRepository losJojosRepo;

    public LosJojosService(JojosRepository losJojosRepo) {
        this.losJojosRepo = losJojosRepo;
    }

    public LosJojos save(LosJojos jojos) {
        return losJojosRepo.save(jojos);
    }

    public List<LosJojos> findAll() {
        return losJojosRepo.findAll();
    }

    public void exportarJson() {
        Gson gson = new Gson();
        List<LosJojos> jojosList = losJojosRepo.findAll();
        try (FileWriter escritor = new FileWriter("src/main/java/org/example/json/Jojos.json")) {
            gson.toJson(jojosList, escritor);
        } catch (Exception e) {
            System.out.println("Error al exportar a JSON: " + e.getMessage());
        }
    }
}
