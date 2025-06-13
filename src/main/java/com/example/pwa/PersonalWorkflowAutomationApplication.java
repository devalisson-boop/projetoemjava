package com.example.pwa;

import com.example.pwa.model.*;
import com.example.pwa.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class PersonalWorkflowAutomationApplication {

    private final UserRepository userRepo;
    private final WorkflowRepository workflowRepo;

    public static void main(String[] args) {
        SpringApplication.run(PersonalWorkflowAutomationApplication.class, args);
    }

    // Cria dados de exemplo ao iniciar
    @PostConstruct
    public void init() {
        if (userRepo.count() == 0) {
            User user = userRepo.save(User.builder()
                    .username("testuser")
                    .email("test@exemplo.com")
                    .password("123")
                    .build());

            WorkflowStep step = WorkflowStep.builder()
                    .type("EMAIL")
                    .params("destino@exemplo.com;Olá!;Este é um workflow de teste.")
                    .stepOrder(1)
                    .build();

            Workflow workflow = Workflow.builder()
                    .name("Meu Primeiro Workflow")
                    .owner(user)
                    .active(true)
                    .steps(List.of(step))
                    .build();

            step.setWorkflow(workflow);

            workflowRepo.save(workflow);
        }
    }
}