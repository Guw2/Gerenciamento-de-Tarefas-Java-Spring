
# --- API de Gerenciamento de Tarefas ---  

  

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-green)  
![Java](https://img.shields.io/badge/Java-21-blue)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)  
![Docker](https://img.shields.io/badge/Docker-✓-lightblue)  

  

Uma API RESTful construída com Spring Boot para gerenciar tarefas de forma eficiente. Este projeto demonstra arquitetura limpa, validação robusta, paginação, filtragem e conteinerização usando Docker.  
 

## ✨ ————— Funcionalidades ————— ✨  

  

- **Operações CRUD**: Criar, ler, atualizar e deletar tarefas  
- **Filtragem Avançada**: Filtrar tarefas por status  
- **Paginação e Ordenação**: Manipulação eficiente de dados  
- **Validação de Entrada**: Usando 'Validation'  
- **Documentação da API**: OpenAPI com Swagger UI  
- **Conteinerização**: Integração com Docker (Aplicação (Java/SB) + MySQL)  

  

## 🛠️ ————— Tecnologias ————— 🛠️  

  

- **Java 21**  
- **Spring Boot 3.5.0**  
- **Spring Data JPA**  
- **MySQL 8.0**  
- **Docker**  
- **Springdoc OpenAPI (Swagger)**  
- **Spring Boot Validation**  

  

## 🚀 ————— Começando ————— 🚀  

  

### 🐳 Configuração com Docker  

  

```bash  
git clone https://github.com/Guw2/TaskManagementApp.git  
cd TaskManagementApp  
docker-compose up --build  
```  

  

### Configuração Local 💻  

  

1. Crie o banco de dados MySQL:  
```sql  
CREATE DATABASE SS_user_auth;  
```  

  

2. Atualize `application.properties`:  
```properties  
spring.datasource.url=jdbc:mysql://localhost:3306/SS_user_auth?useTimezone=true&serverTimezone=UTC  
spring.datasource.username=root  
spring.datasource.password=root  
```  

  

3. Execute a aplicação:  
```bash  
./mvnw spring-boot:run  
```  

  

## => ————— Endpoints da API  ————— =>

  

| MÉTODO | ENDPOINT | DESCRIÇÃO |  
|--------|----------|-----------|  
| GET | `/task` | Obter todas as tarefas |  
| POST | `/task` | Criar nova tarefa |  
| GET | `/task?status={status}` | Obter tarefas filtradas por 'Status' |  
| PUT | `/task/{id}` | Atualizar tarefa existente |  
| DELETE | `/task/{id}` | Deletar tarefa por ID |  

  

### 🔍 Exemplo de Paginação  
```  
GET /task?page=0&size=10  
```  

  

## 📝————— Exemplo de Requisição ————— 📝

  

```json  
{  
	"title": "Exemplo de Título",  
	"description": "Exemplo de descrição.",  
	"status": "PENDING"  
}  
```  

  

## 🛡️————— Regras de Validação  ————— 🛡️

  

- `@NotBlank` para título e descrição  
- `@NotNull` para status  
- Tratador global de exceções retorna mensagens de erro amigáveis  

  

## 📚 ————— Documentação ————— 📚

  

Acesse a documentação interativa da API em:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
