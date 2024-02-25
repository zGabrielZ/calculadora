# API Calculadora

# Tecnologias

## Backend
- Java (Versão 17)
- Maven
- Lombok
- Spring Boot
- JPA/Hibernate
- MockMvc e JUnit
- Bancos de dados PostgresSQL
- Flyway
- Banco de dados H2 (Testes integrado)
- Swagger (Documentação)
- Jacoco
- Docker

## Sobre o projeto

Esta aplicação consiste que o usuário cadastra um tipo de cálculo como soma, subtração, multiplicação e divisão.

## Soma

![Soma](https://github.com/zGabrielZ/assets/blob/main/API%20Calculadora/soma.png)

## Subtração

![Subtração](https://github.com/zGabrielZ/assets/blob/main/API%20Calculadora/subtracao.png)

## Divisão

![Divisão](https://github.com/zGabrielZ/assets/blob/main/API%20Calculadora/divisao.png)

## Multiplicação

![Multiplicação](https://github.com/zGabrielZ/assets/blob/main/API%20Calculadora/multiplicacao.png)

## Modelo conceitual
![Modelo conceitual](https://github.com/zGabrielZ/assets/blob/main/API%20Calculadora/modelo-conceitual.png)

# Como executar o projeto

## Backend 

Pré requisito: Java 17 e Docker

```
# clonar o projeto calculadora api
git clone https://github.com/zGabrielZ/calculadora.git

# clonar o projeto que está com o script do docker yaml do banco de dados postgressql, isso é o ambiente dev
git clone https://github.com/zGabrielZ/configs.git

# entrar na pasta do projeto que consiste o script o docker yaml
 cd '.\Config API Calculadora\postgres-dev\'

# executar o script docker yaml
docker-compose up -d

# apos isso, entrar na pasta backend do projeto api calculadora
cd backend

# rodar a aplicação
./mvnw spring-boot:run
```

Documentação da API: http://localhost:8080/swagger-ui/index.html#/

![Documentação](https://github.com/zGabrielZ/assets/blob/main/API%20Calculadora/swagger.png)

# Autor

Gabriel Ferreira

https://www.linkedin.com/in/gabriel-ferreira-4b817717b/

