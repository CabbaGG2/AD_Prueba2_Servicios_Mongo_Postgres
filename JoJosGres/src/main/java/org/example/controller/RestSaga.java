package org.example.controller;

import org.example.model.Saga;
import org.example.service.PersonaxeService;
import org.example.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestSaga.MAPPING)
public class RestSaga {

    public static final String MAPPING = "/postgres/saga";

    @Autowired
    private SagaService sagaService;

    @Autowired
    private PersonaxeService personaxeService;

    @GetMapping
    public List<Saga> getAll() {
        return sagaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Saga> getById(@PathVariable Long id) {
        return sagaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Saga>> getByTitulo(@PathVariable String titulo){
        return sagaService.findByTitulo(titulo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<Saga> create(@RequestBody Saga saga){
        Saga sagaGuardada = sagaService.save(saga);
        return ResponseEntity.ok(sagaGuardada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if(!sagaService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        sagaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/borrarTodo")
    public void deleteAll() {
        sagaService.deleteAll();
    }
}
