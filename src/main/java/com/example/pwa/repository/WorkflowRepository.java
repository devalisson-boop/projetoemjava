package com.example.pwa.repository;

import com.example.pwa.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
    List<Workflow> findByOwnerId(Long ownerId);
}