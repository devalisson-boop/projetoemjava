package com.example.pwa.controller;

import com.example.pwa.model.Workflow;
import com.example.pwa.repository.WorkflowRepository;
import com.example.pwa.service.WorkflowEngineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflows")
@RequiredArgsConstructor
public class WorkflowController {

    private final WorkflowRepository workflowRepo;
    private final WorkflowEngineService workflowEngineService;

    @GetMapping
    public List<Workflow> getAll() {
        return workflowRepo.findAll();
    }

    @PostMapping("/{id}/execute")
    public String execute(@PathVariable Long id) {
        Workflow workflow = workflowRepo.findById(id).orElseThrow();
        workflowEngineService.executeWorkflow(workflow);
        return "Workflow executado!";
    }
}