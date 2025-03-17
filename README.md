# Projeto de Centro de Treinamentos de Artes Marciais - Full Stack (projeto Decola Tech)

Este projeto visa simular e gerenciar as operações de um **Centro de Treinamentos (CT)** de artes marciais. A aplicação abrange diversas funcionalidades essenciais, como o cadastro de **alunos (students)**, agendamento de **TrialClass** (aulas experimentais), gestão de **instrutores (instructors)**, organização de turmas para **atletas competidores**, agendamento de **eventos** e a administração de **planos de mensalidade**.

## Tecnologias Utilizadas

### Backend
- **Spring Boot**: Framework para desenvolvimento de aplicações Java baseadas em microserviços.
- **Spring Data JPA**: Facilita a integração com bancos de dados relacionais utilizando JPA.
- **Spring Security**: Implementa segurança e autenticação da aplicação.
- **PostgreSQL**: Banco de dados relacional utilizado para persistência de dados.
- **Swagger**: Ferramenta para gerar documentação interativa da API RESTful.

### Frontend
- **Angular**: Framework frontend para a criação da interface de usuário (a ser desenvolvido).
- **API RESTful**: O backend oferece uma API RESTful para comunicação com o frontend.

### Banco de Dados
- **PostgreSQL**: Utilizado como banco de dados principal para armazenar as informações.
- **H2 Database**: Banco de dados em memória utilizado para desenvolvimento local.

## Funcionalidades

### 1. Cadastro de Students
Permite o cadastro de novos **students** no sistema com as seguintes informações:
- Nome completo
- Idade
- Nível de experiência (iniciante, intermediário, avançado)
- Arte marcial praticada
- Contato (telefone e e-mail)
- Ficha básica de saúde (informações sobre condições médicas, se houver)
- Modalidade desejada (por exemplo, Jiu-Jitsu, Muay Thai, Karatê)

### 2. Agendamento de TrialClass (Aulas Experimentais)
O sistema permite que novos **students** agendem até **3 TrialClass** para conhecerem as modalidades disponíveis no CT. A funcionalidade permite a visualização da agenda de aulas e a escolha das preferências de horários.

### 3. Gerenciamento de Instructors (Professores)
Gerencia o cadastro de **instructors** de artes marciais, incluindo:
- Nome completo
- Especialidade (por exemplo, Jiu-Jitsu, Muay Thai)
- Disponibilidade para aulas (dias e horários)

### 4. CompetitionClass (Turma para Atletas Competidores)
Cadastro de turmas específicas para **students** focados em competições, com detalhes como:
- Nível de experiência necessário
- Modalidade específica
- Treinamentos intensivos para competidores

### 5. Gestão de Planos e Mensalidades
Controle completo dos planos de assinatura para **students**, incluindo:
- Cadastro de planos de mensalidade (mensal, trimestral, anual)
- Status de pagamento (pago, pendente)
- Histórico de pagamentos

## Estrutura do Projeto

### Backend

- **src/main/java/com/ctarts**: Contém os pacotes principais do projeto.
  - **controller**: Contém os controladores REST que manipulam as requisições HTTP, como o cadastro de alunos e o agendamento de aulas.
  - **model**: Contém as entidades JPA, que representam as tabelas no banco de dados.
  - **repository**: Contém as interfaces de repositórios responsáveis pela persistência de dados.
  - **service**: Contém a lógica de negócios, com métodos que processam e retornam dados de acordo com as necessidades da aplicação.
  - **dto**: Contém os Data Transfer Objects (DTOs), utilizados para transferir dados entre as camadas da aplicação.

### Banco de Dados
- **PostgreSQL**: Utilizado como banco de dados de produção.
- **H2 Database**: Usado como banco de dados em memória para facilitar o desenvolvimento local e testes rápidos.

### Dependências
- **Spring Boot Starter Web**: Para criar e expor APIs RESTful.
- **Spring Boot Starter Data JPA**: Para a integração do Spring com o banco de dados relacional utilizando JPA.
- **Spring Boot Starter Security**: Para implementar autenticação e controle de acesso seguro.
- **Swagger**: Para gerar documentação interativa da API.

## Configuração do Projeto

### 1. Configuração do Banco de Dados

#### Criação do Banco de Dados:
- Crie um banco de dados **PostgreSQL** com o nome `ctarts`.

#### Configuração do Banco de Dados no Projeto:
Abra o arquivo `src/main/resources/application.properties` e configure as credenciais de conexão ao banco de dados **PostgreSQL**:

```properties
# Configurações de conexão com o banco de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/ctarts
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
````

### 2. Configuração do Swagger
-O Swagger foi integrado ao projeto para gerar a documentação interativa da API. Para acessá-la, basta rodar a aplicação e navegar até o seguinte endereço:
-http://localhost:8080/swagger-ui.html
-Isso permitirá visualizar todas as rotas da API, com exemplos de requisições e respostas.

### 3. Inicialização do Projeto
-Certifique-se de que o PostgreSQL ou H2 Database esteja funcionando corretamente.

### Compile e execute o projeto com o comando:
-mvn spring-boot:run
-O servidor estará disponível em http://localhost:8080.
 
