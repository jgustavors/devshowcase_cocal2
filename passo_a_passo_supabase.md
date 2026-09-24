# 🐘 Passo a Passo: Configurando o Supabase

O **Supabase** é uma plataforma incrível (e gratuita) que fornece um banco de dados **PostgreSQL** na nuvem pronto para uso. Siga este tutorial para criar o banco de dados do seu projeto e pegar as credenciais.

---

## 1️⃣ Criar a Conta e o Projeto

1. Acesse o site oficial: [supabase.com](https://supabase.com)
2. Clique em **"Start your project"** (ou *Sign In* se já tiver conta) e faça login usando o **GitHub**.
3. No painel (Dashboard), clique no botão verde **"New Project"**.
4. Selecione a sua organização (geralmente é o seu próprio nome/usuário).
5. Preencha os dados do projeto:
   - **Name:** `devshowcase-db` (ou qualquer outro nome que preferir).
   - **Database Password:** Crie uma senha **Forte** e **salve ela em um bloco de notas** (você vai precisar dela depois).
   - **Region:** Selecione `South America (São Paulo)` para ficar mais rápido.
6. Clique em **"Create new project"**.
   > ⏳ *Aguarde alguns minutos enquanto o Supabase cria e configura o seu banco de dados.*

---

## 2️⃣ Executar o Script SQL (Criar Tabelas)

Agora que o banco existe, precisamos criar as tabelas de Profiles, Projects, etc.

1. No menu lateral esquerdo do Supabase, clique em **"SQL Editor"** (ícone de um terminal `>_`).
2. Clique no botão **"New query"** (Nova consulta).
3. Abra o arquivo `supabase/init.sql` que está no código do seu projeto no VSCode.
4. **Copie todo o conteúdo** do `init.sql` e **cole** no editor de texto do Supabase.
5. Clique no botão verde **"Run"** (canto inferior direito) ou aperte `Ctrl + Enter`.
6. Se der certo, aparecerá a mensagem verde `Success. No rows returned`.

✅ *Suas tabelas já estão criadas e os dados iniciais das Tecnologias já foram inseridos!*

---

## 3️⃣ Pegar as Credenciais (Variáveis de Ambiente)

Agora você precisa conectar a sua API em Java ao Supabase. Você vai precisar da URL de conexão.

1. No menu lateral esquerdo do Supabase, clique na engrenagem **"Project Settings"** (embaixo, no final).
2. No submenu que abrir, clique em **"Database"**.
3. Role a página até encontrar a seção **"Connection string"**.
4. Selecione a aba **"JDBC"** (que é o formato usado pelo Java/Spring Boot).
5. Copie a URL que vai aparecer. Ela será parecida com isso:
   ```text
   jdbc:postgresql://db.xxxxxxxxx.supabase.co:5432/postgres
   ```
6. (Importante) Onde estiver escrito `[YOUR-PASSWORD]` na URL, lembre-se de que é a senha que você criou lá no Passo 1.

---

## 4️⃣ Onde colocar isso no Render / Deploy

Se você for fazer o deploy da API no Render (ou Railway), na aba de **Environment Variables (Variáveis de Ambiente)** você vai configurar assim:

| Key (Nome) | Value (Valor) |
|---|---|
| `DATABASE_URL` | A url que você copiou (ex: `jdbc:postgresql://db.xxxx.supabase.co:5432/postgres`) |
| `DB_USER` | `postgres` |
| `DB_PASSWORD` | A senha que você criou no Passo 1 |
| `DB_DRIVER` | `org.postgresql.Driver` |

---
🎉 **Fim!** 
Sua aplicação agora está conectada a um banco de dados real e em nuvem!
