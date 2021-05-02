# Ordem de Serviço API

## :page_facing_up: Descrição
Projeto foi desenvolvido seguindo o Curso Spring REST da [AlgaWorks](https://www.algaworks.com). Nesse curso foi aprensentado varios conceitos importantes de arquitetura de uma API REST e Spring, além de mostrar boas práticas, dicas de desenvolvimento e a ultilização adequada dos métodos HTTP e códigos de status.

## :wrench: Ferramentas
- Java 11
- Insomnia
- MySQL Server
- Spring Tools Suite
- Spring Framework
- MySQL Workbench

## :package: Dependencias
- Validation
- Spring Web
- Spring Boot
- MySQL Driver
- Model Mapper
- Spring Data JPA
- Flyway Migration
- Spring Boot DevTools

## :large_orange_diamond: Modelo Relacional

![Modelo Relacional](https://github.com/samueljml/ordem-servico-rest-api/blob/34b896fbd201aa9c0ec5821ed4c72ce6dfc3925c/src/main/resources/image/Modelo%20relacional.png)

## :globe_with_meridians: Rotas
Requisições abaixo foram feitas a partir da porta local: ```http://localhost:8080```

### Clientes

Método  | URI         | Body
:------ | :---------- | :----------------------
GET     | /clientes   | 
GET     | /clientes/1 | 
POST    | /clientes   | nome, email e telefone
PUT     | /clientes/1 | nome, email e telefone
DELETE  | /clientes/1 | 

### Ordens de Serviço

Método  | URI                           | Body
:------ | :---------------------------- | :-----------------
GET     | /ordens-servico               | 
GET     | /ordens-servico/1             | 
POST    | /ordens-servico               | cliente_id, cricao e preco
PUT     | /ordens-servico/1/finalizacao |
DELETE  | /ordens-servico/1             | 

### Comentarios

Método  | URI                           | Body
:------ | :---------------------------- | :------------
GET     | /ordens-servico/1/comentarios | 
POST    | /clientes                     | descricao

## :books: O que aprendi de novo:
- [Migracao de dados com Flyway](https://github.com/samueljml/ordem-servico-rest-api/commit/d75aa1bab15cccd891f93c4fe4d5c9846982fe2a)
- [Restringir o acesso de um atributo](https://github.com/samueljml/ordem-servico-rest-api/commit/e3a97eff80e566286e6c777beb1bdf4979a35aed)
- [Tratamento de exceções com ExceptionHandler](https://github.com/samueljml/ordem-servico-rest-api/commit/7e8b91e702f871cd831b256fa8a69bceb1fdca17)
- [Expor uma instância de uma biblioteca terceira para o Spring](https://github.com/samueljml/ordem-servico-rest-api/commit/f84a4b51b4323a8c9c55b1d70527d1d5db5cfce1)
- [Utilizar o ModelMapper para mapear uma entidade para DTO](https://github.com/samueljml/ordem-servico-rest-api/commit/63e67bf6579d52def99dea6c6a1180f7a76708bd)
- [Não incluir campos nulos no body da resposta utilizando](https://github.com/samueljml/ordem-servico-rest-api/commit/01e989af727ac836e58347cec9da4142f44c6ffe) ```@JsonInclude(Include.NON_NULL)```


## :outbox_tray: Como executar o projeto

- Pré-requisitos: Java 11

```
# Clonar repositório
git clone https://github.com/samueljml/ordem-servico-rest-api.git

# Entrar na pasta do projeto
ordem-servico-rest-api

# Executar API
./mvnw spring-boot:run
```
