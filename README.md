# 🚀 DevShowcase API

API robusta desenvolvida em **Java 17** e **Spring Boot 3** para a plataforma DevShowcase, onde desenvolvedores podem cadastrar seus perfis, adicionar projetos, vincular tecnologias, receber feedbacks (avaliações 1-5 estrelas) e upvotes da comunidade!

## 🛠 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (Web, Data JPA, Validation)
- **Banco de Dados:** H2 Database (desenvolvimento) e PostgreSQL (produção/Supabase)
- **Documentação:** Swagger / OpenAPI
- **Qualidade e Testes:** JUnit 5 e Mockito
- **DevOps:** Docker (Multi-stage build) e GitHub Actions (CI/CD)
- **Segurança/Integração:** CORS configurado para clientes Web

---

## ⚙️ Como rodar o projeto localmente

### Pré-requisitos
- **JDK 17** instalado
- Terminal ou IDE de sua preferência (VSCode, IntelliJ, Eclipse, STS)
- Opcional: Docker instalado

### Opção 1: Via Maven
1. Clone o repositório:
   ```bash
   git clone https://github.com/jgustavors/devshowcase_cocal2.git
   cd devshowcase_cocal2
   ```
2. Execute o projeto usando o Maven Wrapper:
   - No Windows: `.\mvnw.cmd spring-boot:run`
   - No Linux/Mac: `./mvnw spring-boot:run`
3. A API estará rodando na porta `8080`.

### Opção 2: Via Docker
1. Gere o Build da imagem:
   ```bash
   docker build -t devshowcase-api .
   ```
2. Execute o container:
   ```bash
   docker run -p 8080:8080 devshowcase-api
   ```

---

## 🧪 Rodando os Testes Automatizados

O projeto possui testes unitários implementados com **JUnit 5 e Mockito** cobrindo regras de negócio (cálculos de avaliação e upvotes).
Para rodar os testes localmente:
```bash
./mvnw test
```

---

## 🌐 Endpoints Principais

Acesse a documentação interativa completa (Swagger UI) rodando a aplicação e acessando no navegador:
👉 **`http://localhost:8080/swagger-ui.html`**

Ou acesse o banco de dados em memória para testes:
👉 **`http://localhost:8080/h2-console`** *(JDBC URL: `jdbc:h2:mem:testdb` | User: `sa` | Senha: `password`)*

### Projetos (`/api/projects`)
- `POST /api/projects`: Cadastrar um novo projeto.
- `GET /api/projects`: Listar projetos (suporta paginação e filtro `?technology=Java&page=0&size=5`).
- `POST /api/projects/{id}/feedbacks`: Adicionar um feedback com nota (1 a 5) a um projeto. A média é calculada automaticamente.
- `PUT /api/projects/{id}/upvote`: Curtir um projeto.

---

## ☁️ Deploy em Produção (Supabase + Render)

A aplicação está preparada para produção através de variáveis de ambiente. Para subir em produção:

1. Execute o script `supabase/init.sql` no SQL Editor do seu projeto Supabase.
2. No seu serviço de hospedagem (Render, Railway, etc.), configure as seguintes Environment Variables:
   - `DATABASE_URL`: `jdbc:postgresql://<seu-host-supabase>:5432/postgres`
   - `DB_USER`: `postgres`
   - `DB_PASSWORD`: `<sua-senha>`
   - `DB_DRIVER`: `org.postgresql.Driver`

---

*Desenvolvido como projeto prático para a disciplina de Back-end com práticas de nível Pleno/Sênior.* 🚀
