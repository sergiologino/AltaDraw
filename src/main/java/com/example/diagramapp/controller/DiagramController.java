package com.example.diagramapp.controller;

import com.example.diagramapp.entity.Diagram;
import com.example.diagramapp.service.DiagramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagrams")
public class DiagramController {

    private final DiagramService diagramService;

    public DiagramController(DiagramService diagramService) {
        this.diagramService = diagramService;
    }

    @PostMapping("/save")
    public ResponseEntity<Diagram> saveDiagram(@RequestParam String name, @RequestBody String data) {
        Diagram savedDiagram = diagramService.saveDiagram(name, data);
        return new ResponseEntity<>(savedDiagram, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> loadDiagram(@PathVariable Long id) {
        return diagramService.loadDiagram(id)
                .map(diagram -> new ResponseEntity<>(diagram.getData(), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Diagram>> getAllDiagrams() {
        List<Diagram> diagrams = diagramService.getAllDiagrams();
        return new ResponseEntity<>(diagrams, HttpStatus.OK);
    }
}
