# 📦 ControleEstoqueWeb

## Status do Projeto
**Em desenvolvimento (Projeto Acadêmico)**

---

## 💡 Sobre o Projeto

Este projeto foi desenvolvido como atividade acadêmica para o curso técnico de **Análise e Desenvolvimento de Sistemas** do SENAC.

Trata-se da migração de um sistema desktop de controle de estoque para uma aplicação **web**, mantendo as funcionalidades originais e evoluindo a arquitetura para o ambiente web.

---

## 🚀 Funcionalidades

- 📋 **Cadastro de produtos** com nome, quantidade e categoria
- 🔍 **Busca e listagem** de itens em estoque
- ✏️ **Edição e atualização** de produtos cadastrados
- 🗑️ **Exclusão** de itens do estoque
- 🌐 **Interface web** acessível via navegador

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| **Java** | Linguagem principal do back-end |
| **JSP / Servlets** | Camada web e controle de requisições |
| **MySQL** | Banco de dados relacional |
| **JDBC** | Conexão Java com o banco de dados |
| **Maven** | Gerenciador de dependências |
| **NetBeans** | IDE de desenvolvimento |

---

## 📁 Estrutura do Projeto
ControleEstoqueWeb/

├── src/

│   └── main/

│       ├── java/        # Classes Java (Servlets, DAO, Model)

│       └── webapp/      # Páginas JSP e arquivos web

├── pom.xml              # Configuração Maven

└── README.md

---

## ▶️ Como Executar

### Pré-requisitos
- Java JDK 11 ou superior
- NetBeans IDE
- MySQL + Workbench
- Apache Tomcat (integrado ao NetBeans)

### Passo a passo

1. Clone o repositório:
```bash
git clone https://github.com/Edumopee/ControleEstoqueWeb.git
```

2. Abra o projeto no **NetBeans**

3. Configure o banco de dados MySQL com as credenciais no arquivo de conexão

4. Execute o projeto com o servidor **Tomcat**

5. Acesse no navegador: `http://localhost:8080/ControleEstoqueWeb`

---

## 🔗 Projeto Relacionado

Este projeto é a evolução web do sistema desktop:
👉 [SistemaEstoqueWeb](https://github.com/Edumopee/SistemaEstoqueWeb)

---

## 🧑‍💻 Desenvolvedor

**Eduardo Moreno Pereira**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Eduardo%20Moreno-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/eduardo-moreno-pereira)
[![GitHub](https://img.shields.io/badge/GitHub-Edumopee-black?style=flat&logo=github)](https://github.com/Edumopee)
