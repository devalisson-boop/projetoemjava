package com.example.pwa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class WorkflowStep {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // EMAIL, HTTP, etc
    private String params; // JSON simples ou texto

    private int stepOrder;

    @ManyToOne
    private Workflow workflow;
}