🥋 CT-MASTER: API para Gestão de Centros de Treinamento
📄 Sobre o Projeto
O CT-MASTER é uma API RESTful robusta, desenvolvida para gerenciar de forma completa e eficiente as operações de um Centro de Treinamento (CT) de artes marciais. A aplicação foi projetada para centralizar e automatizar processos, oferecendo uma base sólida para um sistema de gestão escalável.

✨ Funcionalidades Principais
[✅] Gestão de Alunos (Students): CRUD completo para alunos, incluindo informações de contato, nível de experiência e ficha básica de saúde.

[✅] Agendamento de Aulas Experimentais (TrialClass): Permite que novos alunos agendem até 3 aulas experimentais para conhecer as modalidades.

[✅] Gerenciamento de Instrutores (Instructors): Cadastro de professores com suas especialidades e horários de disponibilidade.

[✅] Turmas de Competição (CompetitionClass): Criação e gestão de turmas especiais para atletas competidores, com treinamentos intensivos.

[✅] Gestão de Planos e Mensalidades: Administração de planos (mensal, trimestral, anual) e controle do histórico de pagamentos dos alunos.

[✅] Segurança: Autenticação e autorização de endpoints implementadas com Spring Security.

🛠️ Tecnologias Utilizadas
Categoria	Tecnologias
Back-end	Java 17+, Spring Boot 3.x, Spring Security, Maven
Persistência	Spring Data JPA, Hibernate
Banco de Dados	PostgreSQL (Produção), H2 Database (Testes/Dev)
Documentação	SpringDoc (Swagger UI)


🔌 Endpoints da API (Exemplos)
A API segue os princípios REST. Abaixo estão alguns dos principais endpoints:

Verbo HTTP	Endpoint	Descrição
POST	/students	Cadastra um novo aluno no sistema.
GET	/students/{id}	Busca um aluno específico pelo seu ID.
GET	/instructors	Lista todos os instrutores disponíveis.
POST	/trial-classes	Agenda uma nova aula experimental para um aluno.
GET	/competition-classes	Lista as turmas de competição.

Para a lista completa e interativa de endpoints, acesse a documentação do Swagger.

🚀 Como Executar o Projeto
Siga os passos abaixo para configurar e executar a aplicação em seu ambiente local.

✅ Pré-requisitos
Java JDK 17 ou superior
Maven 3.8+
PostgreSQL 14 ou superior

⚙️ Passos para Configuração
Clone o repositório:

Bash
git clone https://github.com/SeuUsuario/CT-MASTER.git
cd CT-MASTER

Configure o Banco de Dados:
Crie um banco de dados PostgreSQL com o nome ctarts.

Abra o arquivo src/main/resources/application.properties e ajuste as credenciais de conexão:
Properties
# Configurações de conexão com o banco de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/ctarts
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres

# Hibernate irá criar/atualizar as tabelas automaticamente
spring.jpa.hibernate.ddl-auto=update
Observação: O projeto também está configurado para usar o banco de dados em memória H2 para facilitar testes rápidos, bastando alterar o perfil do Spring para "dev" ou "test".

Execute a Aplicação:
Pelo terminal, na raiz do projeto, execute o comando do Maven:

Bash
./mvnw spring-boot:run
Após a inicialização, o servidor estará disponível em http://localhost:8080.

Acesse a Documentação da API:
Com a aplicação em execução, acesse a documentação interativa do Swagger no seu navegador:
http://localhost:8080/swagger-ui.html

📂 Estrutura do Backend (Resumo)
O projeto segue os princípios de uma arquitetura em camadas para garantir a separação de responsabilidades:

controller: Controladores REST que manipulam as requisições HTTP.

model: Entidades JPA que mapeiam as tabelas do banco de dados.

repository: Interfaces que definem as operações de acesso a dados (CRUD).

service: Camada que contém a lógica de negócios da aplicação.

dto: Objetos de Transferência de Dados para comunicação entre as camadas.

👨‍💻 Autor
Danilo Mendes
LinkedIn: danilomendesaraujo
GitHub: @Danilo-tec-2003
