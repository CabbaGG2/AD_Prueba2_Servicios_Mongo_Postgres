package org.example.service;

import org.example.model.Personaxe;
import org.example.repository.PersonaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaxeService {

    @Autowired
    private PersonaxeRepository personaxeRepo;

    public List<Personaxe> findAll(){
        return personaxeRepo.findAll();
    }
}
