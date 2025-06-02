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
- **Rota Segura:** Cadastro e consulta de rotas seguras, CRUD completo.


## 🏁 Como rodar

1. Clone o repositório:
  ` ``bash
   git clone https://github.com/JuanPabloRuiz583/gs_java.git

2. Instale as dependências e gere o build:
  ` ``bash
   mvn clean install

3.Execute o projeto:
 ` ``bash
  mvn spring-boot:run
   






#Link do swagger

 http://localhost:8080/swagger-ui.html
