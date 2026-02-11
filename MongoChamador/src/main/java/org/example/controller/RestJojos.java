package org.example.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.model.LosJojos;
import org.example.service.LosJojosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestJojos.MAPPING)
public class RestJojos {
    public static final String MAPPING = "/mongo/jojos";

    @Autowired
    private LosJojosService losJojosService;

    @GetMapping
    public List<LosJojos> getAll() {
        return losJojosService.findAll();
    }

    @PostMapping
    public ResponseEntity<LosJojos> create(@RequestBody LosJojos losJojos) {
        LosJojos guardado = losJojosService.save(losJojos);
        return ResponseEntity.ok(guardado);
    }


}
