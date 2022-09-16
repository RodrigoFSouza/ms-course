package br.com.cronos.hrworker.controllers;

import br.com.cronos.hrworker.entities.Worker;
import br.com.cronos.hrworker.repositories.WorkerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private final WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        final var workers =  workerRepository.findAll();
        return ResponseEntity.ok().body(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") UUID id) {
        final var workerOpt =  workerRepository.findById(id);

        if (workerOpt.isPresent()) {
            return ResponseEntity.ok().body(workerOpt.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
