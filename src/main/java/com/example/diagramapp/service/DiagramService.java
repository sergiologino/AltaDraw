package com.example.diagramapp.service;

import com.example.diagramapp.entity.Diagram;
import com.example.diagramapp.repository.DiagramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagramService {

    private final DiagramRepository diagramRepository;

    public DiagramService(DiagramRepository diagramRepository) {
        this.diagramRepository = diagramRepository;
    }

    public Diagram saveDiagram(String name, String data) {
        Diagram diagram = new Diagram();
        diagram.setName(name);
        diagram.setData(data);
        return diagramRepository.save(diagram);
    }

    public Optional<Diagram> loadDiagram(Long id) {
        return diagramRepository.findById(id);
    }

    public List<Diagram> getAllDiagrams() {
        return diagramRepository.findAll();
    }
}
