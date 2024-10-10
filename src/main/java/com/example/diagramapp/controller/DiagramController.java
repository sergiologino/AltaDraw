package com.example.diagramapp.controller;

import com.example.diagramapp.service.DiagramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diagrams")
public class DiagramController {

    private final DiagramService diagramService;

    public DiagramController(DiagramService diagramService) {
        this.diagramService = diagramService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDiagram(@RequestBody String diagram) {
        String response = diagramService.saveDiagram(diagram);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> loadDiagram(@PathVariable Long id) {
        String diagram = diagramService.loadDiagram(id);
        return new ResponseEntity<>(diagram, HttpStatus.OK);
    }
}
