package com.example.diagramapp.service;

import org.springframework.stereotype.Service;

@Service
public class DiagramService {
    public String saveDiagram(String diagram) {
        // Здесь будет логика сохранения схемы.
        return "Diagram saved";
    }

    public String loadDiagram(Long id) {
        // Здесь будет логика загрузки схемы по ID.
        return "{ \"message\": \"Diagram data\" }";
    }
}
