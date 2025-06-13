package com.example.pwa.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Workflow {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean active;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkflowStep> steps;
}