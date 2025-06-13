package com.example.pwa.service;

import com.example.pwa.model.Workflow;
import com.example.pwa.model.WorkflowStep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class WorkflowEngineService {

    private final EmailService emailService;

    public void executeWorkflow(Workflow workflow) {
        workflow.getSteps().stream()
            .sorted(Comparator.comparingInt(WorkflowStep::getStepOrder))
            .forEach(this::executeStep);
    }

    private void executeStep(WorkflowStep step) {
        switch (step.getType()) {
            case "EMAIL" -> {
                // Espera-se que params seja "to;subject;body"
                String[] split = step.getParams().split(";", 3);
                emailService.sendEmail(split[0], split[1], split[2]);
            }
            default -> throw new IllegalArgumentException("Tipo de step não implementado: " + step.getType());
        }
    }
}