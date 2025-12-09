# API Rest: Gerenciamento de Aeroportos ✈

Este projeto é uma API REST desenvolvida como Trabalho Prático. O objetivo é gerenciar o cadastro de aeroportos globais utilizando dados do projeto OpenFlights.

##  Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **MySQL** (Banco de Dados Relacional)
* **Maven** (Gerenciamento de Dependências e Build)
* **Lombok** (Redução de boilerplate)
* **JUnit 5 & Mockito** (Testes de Unidade e Integração)

##  Configuração e Execução

### Pré-requisitos
* Java 17 instalado.
* MySQL rodando na porta 3306.

### Passo a Passo
1.  Clone este repositório:
    ```bash
    git clone [https://github.com/davimartins27/api-rest-aeroportos.git](https://github.com/davimartins27/api-rest-aeroportos.git)
    ```
2.  Configure a senha do seu banco de dados no arquivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.password=SUA_SENHA_AQUI
    ```
3.  Execute a aplicação pela primeira vez para que o Hibernate crie a tabela `aeroporto` automaticamente.
4.  **Importação de Dados:** Utilize um cliente SQL (IntelliJ Database, DBeaver ou Workbench) para importar o arquivo `airports.csv` para a tabela `aeroporto`, mapeando as colunas conforme o dicionário de dados.

##  Endpoints da API

A API segue o padrão REST e possui os seguintes endpoints:

| Método | URL | Descrição |
|---|---|---|
| `GET` | `/api/v1/aeroportos` | Lista todos os aeroportos cadastrados. |
| `GET` | `/api/v1/aeroportos/{iata}` | Busca um aeroporto pelo código IATA (ex: CNF). |
| `POST` | `/api/v1/aeroportos` | Cadastra um novo aeroporto. |
| `PUT` | `/api/v1/aeroportos/{iata}` | Atualiza os dados de um aeroporto existente. |
| `DELETE` | `/api/v1/aeroportos/{iata}` | Remove um aeroporto do sistema. |

##  Como Executar os Testes

O projeto implementa testes automatizados cobrindo unidades lógicas e integração, configurados via plugins Maven:

* **Testes de Unidade:** Focam na lógica de negócio e utilizam **Mockito** para isolar dependências.
    * Comando: `mvn test` (Executa via Maven Surefire Plugin)
* **Testes de Integração:** Testam os endpoints de ponta a ponta carregando o contexto do Spring.
    * Comando: `mvn verify` (Executa via Maven Failsafe Plugin)