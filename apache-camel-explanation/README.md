# Apache Camel CRUD Spring Boot Example

Este projeto demonstra um exemplo CRUD usando Apache Camel, Spring Boot, JPA e PostgreSQL.

## Dependências Necessárias no Spring Initializer

Para recriar este projeto no [Spring Initializr](https://start.spring.io/), use as seguintes configurações:

### Configurações do Projeto
- **Project**: Maven Project
- **Language**: Java
- **Spring Boot**: 3.2.2
- **Group**: com.example
- **Artifact**: apache-camel-explanation
- **Name**: Apache Camel CRUD Spring Boot Example
- **Description**: Exemplo CRUD com Apache Camel, Spring Boot, JPA, Lombok, Validation
- **Package name**: com.example.camel
- **Packaging**: Jar
- **Java**: 17

### Dependências Spring Boot
Selecione as seguintes dependências no Spring Initializr:

1. **Spring Web** - Para criar APIs REST
2. **Spring Data JPA** - Para persistência de dados
3. **Validation** - Para validação de dados
4. **PostgreSQL Driver** - Driver para PostgreSQL
5. **Lombok** - Para reduzir código boilerplate

### Dependências Adicionais (Adicionar manualmente no pom.xml)

Após gerar o projeto, adicione as seguintes dependências do Apache Camel no `pom.xml`:

```xml
<properties>
    <java.version>17</java.version>
    <camel.version>4.2.0</camel.version>
</properties>

<dependencies>
    <!-- Dependências do Apache Camel -->
    <dependency>
        <groupId>org.apache.camel.springboot</groupId>
        <artifactId>camel-spring-boot-starter</artifactId>
        <version>${camel.version}</version>
    </dependency>
    
    <!-- Para testes com Camel -->
    <dependency>
        <groupId>org.apache.camel.springboot</groupId>
        <artifactId>camel-spring-boot-starter-test</artifactId>
        <version>${camel.version}</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Configuração do Banco de Dados

### 1. Docker Compose para PostgreSQL

O projeto inclui um arquivo `docker-compose.yml` para executar PostgreSQL:

```bash
docker-compose up -d
```

### 2. Configuração JDBC

O arquivo `application.yml` contém as configurações necessárias para conectar ao PostgreSQL.

## Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+
- Docker e Docker Compose

### Passos

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd apache-camel-explanation
```

2. Inicie o PostgreSQL com Docker:
```bash
docker-compose up -d
```

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

## Endpoints da API

### Criar Pessoa
```http
POST /api/persons
Content-Type: application/json

{
    "name": "João Silva",
    "age": 30
}
```

### Buscar Pessoa por ID
```http
GET /api/persons/{id}
```

### Atualizar Pessoa
```http
PUT /api/persons/{id}
Content-Type: application/json

{
    "name": "João Santos",
    "age": 31
}
```

### Deletar Pessoa
```http
DELETE /api/persons/{id}
```

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/camel/
│   │       ├── ApacheCamelExplanationApplication.java
│   │       ├── CamelRouteConfig.java
│   │       ├── controller/
│   │       │   └── PersonController.java
│   │       ├── model/
│   │       │   └── Person.java
│   │       ├── processor/
│   │       │   ├── PersonCreateProcessor.java
│   │       │   ├── PersonDeleteProcessor.java
│   │       │   ├── PersonReadProcessor.java
│   │       │   └── PersonUpdateProcessor.java
│   │       ├── repository/
│   │       │   └── PersonRepository.java
│   │       └── route/
│   │           └── PersonRoute.java
│   └── resources/
│       └── application.yml
├── docker-compose.yml
└── pom.xml
```

## Tecnologias Utilizadas

- **Spring Boot 3.2.2** - Framework principal
- **Apache Camel 4.2.0** - Para integração e roteamento
- **Spring Data JPA** - Para persistência de dados
- **PostgreSQL** - Banco de dados
- **Lombok** - Para reduzir código boilerplate
- **Bean Validation** - Para validação de dados
- **Docker** - Para containerização do banco de dados

## Conceitos Demonstrados

- **Apache Camel Routes** - Roteamento de mensagens
- **Camel Processors** - Processamento de dados
- **Spring Boot Integration** - Integração com Spring
- **JPA/Hibernate** - Mapeamento objeto-relacional
- **REST API** - Endpoints RESTful
- **Docker Compose** - Orquestração de containers
