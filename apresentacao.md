# 🎯 Roteiro de Apresentação e JSONs para Testes

Este arquivo contém tudo o que você precisa copiar e colar durante a apresentação no Swagger ou Postman, na ordem exata. 
**Dica:** Deixe este arquivo aberto do lado esquerdo e o navegador do lado direito.

---

## 1️⃣ PASSO 1: Cadastrar um Perfil
**Onde:** `POST /api/profiles`

```json
{
  "name": "Gustavo Rodrigues",
  "bio": "Desenvolvedor Backend Java",
  "githubUsername": "jgustavors",
  "avatarUrl": "https://github.com/jgustavors.png",
  "linkedinUrl": "https://linkedin.com/in/gustavo"
}
```
*-> Copie o `id` que vai retornar (provavelmente será `1`).*

---

## 2️⃣ PASSO 2: Cadastrar uma Tecnologia
**Onde:** `POST /api/technologies`

```json
{
  "name": "Spring Boot",
  "iconUrl": "https://icon.com/spring.png"
}
```
*-> Copie o `id` que vai retornar (provavelmente será `1`).*

---

## 3️⃣ PASSO 3: Criar um Projeto vinculando o Perfil e a Tecnologia
**Onde:** `POST /api/projects`

```json
{
  "title": "DevShowcase API",
  "description": "API REST profissional para portfólios de desenvolvedores.",
  "repositoryUrl": "https://github.com/jgustavors/devshowcase_cocal2",
  "profileId": 1,
  "technologyIds": [1]
}
```
*-> Copie o `id` do projeto criado (provavelmente será `1`).*

---

## 4️⃣ PASSO 4: Testar Validação e Tratamento de Erros (Diferencial Sênior)
**Onde:** `POST /api/projects/1/feedbacks`

> Fale: "Vejam como tratamos erros se o usuário mandar uma nota inválida (ex: 10)."
> Cole este JSON:

```json
{
  "author": "Professor",
  "comment": "Projeto excelente, mas a nota está errada.",
  "rating": 10
}
```
*-> O sistema deve retornar Erro 400 com JSON amigável dizendo "A nota máxima é 5".*

---

## 5️⃣ PASSO 5: Testar Regra de Negócio da Etapa 2 (Feedbacks)
**Onde:** `POST /api/projects/1/feedbacks`

> Fale: "Agora enviando um feedback correto, nossa lógica de serviço vai recalcular a média do projeto automaticamente."

**Feedback 1:**
```json
{
  "author": "Avaliador 1",
  "comment": "Muito bom!",
  "rating": 5
}
```

**Feedback 2:**
```json
{
  "author": "Avaliador 2",
  "comment": "Gostei bastante, falta só front-end.",
  "rating": 4
}
```

---

## 6️⃣ PASSO 6: Adicionar um Upvote (Curtida)
**Onde:** `PUT /api/projects/1/upvote`
*(Não precisa de JSON, só passar o ID 1 na URL e executar umas 2 ou 3 vezes)*

---

## 7️⃣ PASSO 7: Mostrar o Resultado Final Filtrado e Paginado
**Onde:** `GET /api/projects`

Coloque nos parâmetros:
- `technology`: Spring Boot
- `page`: 0
- `size`: 5

> O resultado vai mostrar o projeto com `averageRating: 4.5`, com seus feedbacks atrelados, upvotes somados e informações do perfil, tudo numa estrutura paginada.

---
🚀 **Boa Apresentação!**
