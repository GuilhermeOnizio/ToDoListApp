# :star2: Gerenciador de Tarefas

Este é um projeto de um Gerenciador de Tarefas simples, desenvolvido utilizando React.js no front-end e Spring Boot no back-end. O sistema permite aos usuários gere1nciar uma lista de tarefas com funcionalidades para adicionar, marcar como concluída e excluir tarefas.

## Funcionalidades

Front-end:

- Listagem de tarefas com opção de marcar como concluídas ou pendentes.
- Adição de novas tarefas.
- Remoção de tarefas.
- Interface responsiva e fácil de usar.

Back-end:

- Endpoints REST para gerenciamento de tarefas:
 - GET /api/tarefas: Lista todas as tarefas.
 - POST /api/tarefas: Adiciona uma nova tarefa.
 - PUT /api/tarefas/{id}: Atualiza o status de uma tarefa (concluída/pendente).

## Tecnologias Utilizadas

Front-end:

- React.js
- Axios para comunicação com a API
- CSS para estilização

Back-end:

- Spring Boot
- Java 23
- Lista em memória para armazenar tarefas (simulação sem banco de dados)

## Passos para rodar o projeto

Requisitos:

Node.js (v16 ou superior)
Java 17
Maven

- Passos para Executar o Back-end:

  1. Clone o repositório.
  2. Navegue até a pasta do back-end.
  3. Execute o comando: mvn spring-boot:run.
  4. O servidor estará disponível em: http://localhost:8080.

- Passos para Executar o Front-end:

  1. Navegue até a pasta do front-end.
  2. Execute o comando: npm install para instalar as dependências.
  3. Execute o comando: npm start para iniciar o servidor de desenvolvimento.
  4. Acesse a aplicação em: http://localhost:3000.

