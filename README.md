# Projeto de Centro de Treinamentos de Artes Marciais - Full Stack

Este projeto tem como objetivo simular a gestão de um centro de treinamentos (CT) de artes marciais. Ele inclui funcionalidades como o cadastro de **students**, agendamento de **TrialClass** (aulas experimentais), gerenciamento de **instructors** (professores), turmas específicas para atletas competidores, agenda de eventos e gestão de planos e mensalidades.

## Tecnologias Utilizadas

- **Backend**:
  - Spring Boot
  - Spring Data JPA
  - Spring Security
  - PostgreSQL
  - Swagger

- **Frontend**:
  - Angular (a ser desenvolvido)
  - API RESTful

- **Banco de Dados**:
  - PostgreSQL (com H2 para desenvolvimento)

## Funcionalidades

### 1. Cadastro de **students**
Permite o cadastro de novos **students**, incluindo informações como:
- Nome
- Idade
- Nível de experiência
- Arte marcial praticada
- Contato
- Ficha básica de saúde
- Modalidade desejada

### 2. Agendamento de **TrialClass** (Aulas Experimentais)
Permite que novos **students** agendem até 3 **TrialClass** no CT para conhecerem as modalidades.

### 3. Gerenciamento de **instructors** (Professores)
Cadastro de **instructors** de artes marciais, com:
- Nome
- Especialidade
- Disponibilidade

### 4. **competitionClass** (Turma para Atletas Competidores)
Cadastro de turmas específicas para atletas com foco em competições, incluindo informações sobre o nível de experiência e modalidades.

### 5. Agenda de Eventos
Agenda de eventos com a possibilidade de adicionar aulões misturando várias modalidades de artes marciais.

### 6. Gestão de Planos e Mensalidades
Controle dos planos de assinatura para os **students** e a gestão dos pagamentos mensais, incluindo:
- Plano de mensalidade
- Status de pagamento

## Estrutura do Projeto

### Backend

- **src/main/java/com/ctarts**: Contém todos os pacotes principais do projeto.
  - **controller**: Contém os controladores REST para manipulação das requisições HTTP.
  - **model**: Contém as entidades JPA que representam as tabelas no banco de dados.
  - **repository**: Contém interfaces de repositórios responsáveis pela persistência de dados.
  - **service**: Contém a lógica de negócio, com métodos que são invocados pelos controladores.
  - **dto**: Contém os Data Transfer Objects (DTOs), usados para transferir dados entre as camadas.

### Banco de Dados

- **PostgreSQL**: O banco de dados relacional utilizado.
- **H2 Database**: Utilizado para o desenvolvimento local (em memória).
  
### Dependências

- **Spring Boot Starter Web**: Para criação de APIs RESTful.
- **Spring Boot Starter Data JPA**: Para integração com banco de dados usando JPA.
- **Spring Boot Starter Security**: Para autenticação e segurança.
- **Spring Boot Starter Test**: Para testes unitários e de integração.
- **Swagger**: Para documentação da API.

## Configuração do Projeto

### 1. Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL.
2. Configure as credenciais de conexão no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ctarts
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

