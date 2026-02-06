# Bootcamp Deloitte - API de Produtos

API RESTful desenvolvida em Spring Boot durante o Bootcamp Java Deloitte para gerenciamento de produtos.

## 📋 Sobre o Projeto

Esta aplicação é uma API REST que implementa operações CRUD para gerenciamento de produtos, seguindo as melhores práticas de desenvolvimento com Spring Boot, incluindo camadas de controller, service, repository, além de DTOs para transferência de dados e tratamento personalizado de exceções.

## 🛠️ Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Spring Boot** - Framework para desenvolvimento
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - Criação de APIs REST
- **H2 Database** - Banco de dados em memória
- **Swagger/OpenAPI** - Documentação interativa da API
- **Maven** - Gerenciamento de dependências
- **Azure App Service** - Hospedagem em nuvem

## 📁 Estrutura do Projeto

```txt
com.joseph.bootcampDeloitte/
├── controller/          # Endpoints REST
│   └── ProdutoController
│
├── dto/                # Objetos de transferência de dados
│   ├── ProdutoRequestDTO
│   └── ProdutoResponseDTO
│
├── exception/          # Tratamento de exceções
│   ├── GlobalExceptionHandler
│   ├── NenhumProdutoCadastradoException
│   ├── ProdutoDuplicadoException
│   └── ProdutoNaoEncontradoException
│
├── mapper/             # Conversão entre entidades e DTOs
│   └── ProdutoMapper
│
├── model/              # Entidades JPA
│   └── Produto
│
├── repository/         # Camada de acesso a dados
│   └── ProdutoRepository
│
└── service/            # Regras de negócio
    └── impl/
        └── ProdutoServiceImpl
```

## 🚀 Como Executar Localmente

### Pré-requisitos

- Java 21
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, VS Code)

> **OBS.:** O banco de dados H2 já está incluído como dependência do projeto, não sendo necessária instalação separada.

### Passos para execução

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd bootcamp-deloitte
```

2. **Configure o banco de dados**

O projeto utiliza **H2 Database** para persistência de dados. A configuração está no arquivo `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:bootcampdb
    driver-class-name: org.h2.Driver
    username: sa
    password:

  jpa:
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.H2Dialect
    show-sql: true

  h2:
    console:
      enabled: true
      path: /h2-console

server:
  port: {PORT:8080}

```

Para acessar o console H2 em desenvolvimento:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:bootcampdb`
- Username: `sa`
- Password: (deixe em branco)

3. **Compile o projeto**
```bash
mvn clean install -Dmaven.test.skip=true
```

4. **Execute a aplicação**
```bash
mvn spring-boot:run
```

Ou execute diretamente o JAR gerado:
```bash
java -jar target/bootcamp-deloitte-0.0.1-SNAPSHOT.jar
```

5. **Acesse a aplicação**

A API estará disponível em: `http://localhost:8080`

## 📚 Documentação da API (Swagger)

A API possui documentação interativa gerada automaticamente com **Swagger/OpenAPI**, permitindo visualizar e testar todos os endpoints diretamente no navegador.

### Acesso Local

Após iniciar a aplicação localmente, acesse:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### Acesso em Produção

A documentação também está disponível no ambiente de produção:
- Swagger UI: `https://bootcamp-produtos-josephmatheus.azurewebsites.net/swagger-ui.html`
- OpenAPI JSON: `https://bootcamp-produtos-josephmatheus.azurewebsites.net/v3/api-docs`

### Funcionalidades do Swagger

- 📋 Visualização completa de todos os endpoints
- 🧪 Testes interativos direto na interface
- 📖 Documentação automática dos modelos (DTOs)
- ✅ Validação de schemas de request/response
- 🔍 Detalhamento de códigos de status HTTP

## 📡 Endpoints da API

### Produtos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca produto por ID |
| POST | `/produtos` | Cadastra novo produto |
| PUT | `/produtos/{id}` | Atualiza produto existente |
| DELETE | `/produtos/{id}` | Remove produto |

### Exemplo de Request (POST/PUT)

```json
{
  "nome": "Notebook Dell",
  "preco": 3500.00
}
```

### Exemplo de Response

```json
{
  "id": 1,
  "nome": "Notebook Dell",
  "preco": 3500.00
}
```

## ☁️ Deploy na Azure

### Ambiente de Produção

A aplicação está hospedada no **Azure App Service** e pode ser acessada através da URL:

**🔗 URL da Aplicação:** `https://bootcamp-produtos-josephmatheus.azurewebsites.net`

### Processo de Deploy

O deploy para o Azure é realizado através do **Maven Azure Plugin**, que está configurado no `pom.xml` do projeto.

#### Como fazer o Deploy

1. **Build e Deploy**

   Execute o comando para build e deploy em um único passo:
   ```bash
   mvn azure-webapp:deploy
   ```

   O plugin irá:
    - Compilar a aplicação
    - Gerar o arquivo JAR
    - Fazer o upload para o Azure App Service
    - Iniciar a aplicação automaticamente

2. **Informações do Deploy**

    - **Resource Group**: (definido no pom.xml)
    - **App Service**: `bootcamp-produtos-josephmatheus`
    - **Subscription**: Azure subscription 1
    - **Runtime**: Java 21
    - **Artifact**: `bootcampDeloitte-0.0.1-SNAPSHOT.jar`

### Configuração de Variáveis de Ambiente

- `PORT` - Porta da aplicação (padrão: 8080)

## 📝 Tratamento de Exceções

A API implementa tratamento centralizado de exceções:

- `NenhumProdutoCadastradoException` - Quando não há produtos cadastrados
- `ProdutoDuplicadoException` - Ao tentar cadastrar produto duplicado
- `ProdutoNaoEncontradoException` - Quando produto não é encontrado
- `GlobalExceptionHandler` - Handler global para todas as exceções
