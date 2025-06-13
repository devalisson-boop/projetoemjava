# Meu Projeto Spring Boot

Projeto de exemplo para automatizar tarefas pessoais.

## Como rodar

```sh
mvn spring-boot:run
```

Acesse: http://localhost:8080

## Banco de Dados

A aplicação usa H2 em memória.

Para acessar o console do banco:
- Vá em http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (vazio)
