package com.example.pwa.service;

import com.example.pwa.model.Workflow;
import com.example.pwa.model.WorkflowStep;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkflowEngineServiceTest {

    @Test
    void testExecuteWorkflow() {
        EmailService emailService = new EmailService();

        WorkflowStep step = WorkflowStep.builder()
                .type("EMAIL")
                .params("a@b.com;Assunto;Mensagem")
                .stepOrder(1)
                .build();

        Workflow workflow = Workflow.builder()
                .steps(List.of(step))
                .build();

        WorkflowEngineService engine = new WorkflowEngineService(emailService);

        assertDoesNotThrow(() -> engine.executeWorkflow(workflow));
    }
}