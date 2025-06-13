package com.example.pwa.repository;

import com.example.pwa.model.WorkflowStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowStepRepository extends JpaRepository<WorkflowStep, Long> {
}