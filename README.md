# SafeRoute

SafeRoute é uma solução inteligente para salvar vidas durante desastres naturais, conectando pessoas em risco a alertas em tempo real, abrigos próximos e rotas seguras.

## 🚀 Visão Geral

Com o aumento de eventos extremos como enchentes, deslizamentos e incêndios, o SafeRoute foi criado para ajudar pessoas a escaparem rapidamente e com segurança. A plataforma permite:

- Criação de alertas sobre situações de risco.
- Localização do abrigo mais próximo.
- Exibição da rota mais segura até o abrigo.
- Integração com sensores IoT para alertas automáticos.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security (JWT)
- Maven
- Banco de Dados Relacional (PostgreSQL)
- Swagger/OpenAPI
- Spring Data JPA
- Lombok
- Busca de abrigos com paginação, filtro e ordenação

## 🔒 Autenticação

A API utiliza autenticação JWT para proteger os endpoints. Usuários devem se autenticar para acessar recursos protegidos.

## 📚 Documentação

A documentação interativa está disponível via Swagger em  http://localhost:8080/swagger-ui.html após rodar o projeto.

## 📦 Funcionalidades

- **Usuário:** Cadastro, autenticação e gerenciamento.
- **Alerta:** Cadastro de alertas de risco pelo usuario ,CRUD completo.
- **Abrigo:** Cadastro e consulta de abrigos, CRUD completo.
- **Rota Segura:** Cadastro e consulta de rotas seguras com base no alerta e abrigo criado, CRUD completo.


## 🏁 Como rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/JuanPabloRuiz583/gs_java.git

2. Instale as dependências e gere o build:
   ```bash
   mvn clean install

3. Execute o projeto:
   ```bash
   mvn spring-boot:run

## Instruções para acesso e testes

passo 1: Ao rodar a aplicação e acessar o swagger, todos os endpoints estaram bloqueados exeto o de cadastro de usuarios e de login. Comece cadastrando o usuario, va no post user e crie um usuario:

![passo1](https://github.com/user-attachments/assets/64beda73-7d3f-4b51-af10-ab31a938d4e8)

passo 2: apos criar o usuario, va ate a auth controller no endpoint de login, digite o email e senha de usuario que voce criou

![passo2](https://github.com/user-attachments/assets/58080e37-09a9-4d8c-8c8d-4ae62a995c05)

passo 3: ao digitar suas credenciais corretas no endpoint de login, ele te retornara um token, copia esse token

![passo3](https://github.com/user-attachments/assets/6fc8d2a5-083f-4829-8195-2442bd993894)

passo 4: suba para o topo da tela e clique no cadeado escrito authorize

![passo4](https://github.com/user-attachments/assets/db8b50d4-eab6-499b-ade2-b95e1e66ce0c)

passo 5: ao clicar no cadeado, cole o token que voce copiou e clique em authorize

![passo5](https://github.com/user-attachments/assets/85c4e2ca-6ecc-438c-b327-c912738bc10f)

passo 6: apos isso clique no x , para fechar a janela e volte para a tela principal(voce ira perceber que o cadeado em todas as requisiçoes fechou, é sinal que deu certo), sendo assim se voce digitou o token certo todos os endpoints da api estarao liberados para voce testar

![tela6](https://github.com/user-attachments/assets/f5db2781-08fa-439c-8809-90e1a6fd40f2)

![tela7](https://github.com/user-attachments/assets/674a2e4e-975e-45f0-9368-59797f70c614)



## Link do swagger

 http://localhost:8080/swagger-ui.html


 ## Integrantes

Barbara Dias Santos rm: 556974

Natasha Lopes Rocha Oliveira rm: 554816

Juan Pablo Ruiz de Souza rm: 557727

